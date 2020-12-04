package com.myapp.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myapp.dto.Employee;
import com.myapp.service.EmployeeService;
import com.myapp.util.UserException;

@Controller
public class CommonController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private MessageSource messageSource;

	/**
	Req#1:
	------------
	Provide the Register functionality.
	When customer clicks on "Register" link show register page.
	customer will enter data ON register page and clicks on "submit"  -> if validation is success
	in backend save a row in "Employee_Details" table.
	
	 */
	@RequestMapping("/register")
	public ModelAndView showAddEmp() {
		Employee employee = new Employee();
		return new ModelAndView("register", "command", employee);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView addEmp(
			@Valid @ModelAttribute("employee") Employee employee, 
			BindingResult result) {
		if (result.hasErrors()) {
			String message = getErrorMsg(result);
			ModelAndView model = new ModelAndView("register", "command", employee);
			model.addObject("msg", message);
			return model;
		}

		try {
			employeeService.addEmployee(employee);
		} catch (UserException e) {
			String msg = e.getMessage();
			ModelAndView modelAndView = new ModelAndView("register", "command", employee);
			modelAndView.addObject("msg", msg);
			return modelAndView;
		}
		ModelAndView model = new ModelAndView("login", "emp", employee);
		model.addObject("msg", "Employee Created!");
		return model;
	}

	// method when customer clicks on login link
	@RequestMapping("/login")
		public String login() throws Exception {
			return "login";
		}

	/**
	 // method when cutsomer clicks on login button
		//check if the loginname and pawd are matching in the db
		//if the login is success then save the customer name in session and show home page
		//if the login is success then show login page with error msg "invalid login"
	How to access session data in header.jsp:-
	----------------------------------
	Welcome ${name}<br>
	
	here name is the "session" data stored when login is sucees.
	session.setAttribute("name", validUser.getName())

	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("command") Employee employee, BindingResult result, HttpSession session) {
		// make a db call and check if login is valid
		Employee validUser = employeeService.getValidEmpByAuth(employee);
		if (validUser != null) {
			// login success show profile.jsp
			session.setAttribute("myId", validUser.getId());
			session.setAttribute("loginName", validUser.getLoginName());
			session.setAttribute("name", validUser.getName());
			ModelAndView modelAndView = new ModelAndView("profile", "emp", validUser);
			return modelAndView;
		} else {
			// login failure show login.jsp
			return new ModelAndView("login", "msg", "Invalid Login..");
		}
	}
	
	/*controller method when cutsomer clicks on "MyProfile" link
	
	Url rewriting:
	----------------------------
	<a href="profile?loginName=${loginName}" name="My Profile" value="My Profile">My Profile </a>&nbsp;&nbsp;&nbsp;
	Along with url we can send data

	1.
	<a href="profile" >My Profile </a>        -> url without data 
	if we click then url will be http://localhost:8081/SpringMvcWithHibernate/profile 


	<a href="profile?loginName=${loginName}" >My Profile </a>  -> url with loginame 
	if we click then url will be http://localhost:8081/SpringMvcWithHibernate/profile?loginName=Vishnu
	
	*/
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView profile(@RequestParam("loginName") String name) {
		Employee validUser = employeeService.getEmpByName(name);
		if (validUser!=null){
			ModelAndView modelAndView = new ModelAndView("profile", "emp", validUser);
			return modelAndView;
		}
		return new ModelAndView("profile", "msg", "No emp exist");
	}
	
	//For logout , delete all the data in the session and the show login page with msg "Logout successfull"
	//controller method when customer clicks on logout link
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.removeAttribute("loginName");
		session.removeAttribute("name");
		session.invalidate();
		ModelAndView response = new ModelAndView("login");
		response.addObject("msg", "Logout successfull");
		return response;
	}
	
	private String getErrorMsg(BindingResult result) {
		String message = "";
		for (Object object : result.getAllErrors()) {
		    if(object instanceof FieldError) {
		        FieldError fieldError = (FieldError) object;
		        message = messageSource.getMessage(fieldError, null);
		        break;
		    }
		}
		return message;
	}
}
