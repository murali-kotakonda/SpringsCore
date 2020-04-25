package com.mythri.controllers;

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

import com.mythri.dto.Employee;
import com.mythri.service.EmployeeService;
import com.mythri.util.UserException;

@Controller
public class CommonController {

	private static final String EMP = "emp";

	private static final String LOGIN_NAME = "loginName";

	public static final String COMMAND = "command";

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private MessageSource messageSource;

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
			ModelAndView modelAndView = new ModelAndView("register", COMMAND, employee);
			modelAndView.addObject("msg", msg);
			return modelAndView;
		}
		ModelAndView model = new ModelAndView("login", EMP, employee);
		model.addObject("msg", "Employee Created!");
		return model;
	}

	@RequestMapping("/login")
	public String login() throws Exception {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute(COMMAND) Employee employee,
			BindingResult result,HttpSession session) {
		Employee validUser = employeeService.getValidEmpByAuth(employee);
		if (validUser!=null){
			session.setAttribute("myId", validUser.getId());
			session.setAttribute("loginName", validUser.getLoginName());
			session.setAttribute("name",validUser.getName() + "," + employee.getlName());
			ModelAndView modelAndView = new ModelAndView("profile",EMP,validUser);
			return modelAndView;
		}
		return new ModelAndView("login","msg","Invalid Login..");
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView profile(@RequestParam(LOGIN_NAME) String name) {
		Employee validUser = employeeService.getEmpByName(name);
		if (validUser!=null){
			ModelAndView modelAndView = new ModelAndView("profile", EMP, validUser);
			return modelAndView;
		}
		return new ModelAndView("profile", "msg", validUser);
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.removeAttribute("loginName");
		session.removeAttribute("name");
		session.invalidate();
		ModelAndView response = new ModelAndView("login");
		response.addObject("msg","Logout successfull");
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
