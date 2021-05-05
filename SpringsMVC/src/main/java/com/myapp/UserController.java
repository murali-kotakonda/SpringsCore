package com.myapp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myapp.dto.User;
import com.myapp.exception.EmployeeException;

/**
 * @author I335484
 *
 */
@Controller
public class UserController {
	
	@Autowired
	UserService service;

/*
	Activity:
	1.Capture the request data
	and
	2.Keep request data inside the object - done by springs
	
	request capturing + keep req data inside the obj becomes complex/more lines of code when 
    we have many fields coming from the web page
	
	Requirement:
	------------------
	capture the following info from the web page and show the submitted data in response jsp
	  firstname
	  lastname   
	  email
	  telephone
	  age
	  city   - dropdown
	  gender   - radio
	  idProofs  - checkbox
	  address  - textarea
	  
	 Technically:
	-----------------------
	  reqPage  jsp
	  response jsp
	  controller method
	
	Java changes:
	1.Create new Controller: UserController.java
	2.Create a pojo class : UserInfo.java
	  for every web page that has a  form there is a  associated java class
	  
	 Since Springs is perforimg req capturing + setting data in the pojo obj.
     - we need to use the spring tags in req jsp
     - use @ModelAttribute in controller method.
   
	the field name in addUser.jsp is equal to the instance variable of UserInfo.java
	
	In web page use  : spring tags
	In java -> instead of @RequestParam use @ModelAttribute
	
	1. convert the web form data to the java obj  [ client ---> server]
	2. Using the java obj prepare the form [server --> client]
*/
	
	@RequestMapping(value = "/user1", method = RequestMethod.GET)
	public ModelAndView showUserForm1() {
		return new ModelAndView("addUser1", "userData",new UserInfo());
	}
	
	@RequestMapping(value = "/addNewUser", method = RequestMethod.POST)
	public ModelAndView addUser1(
			@ModelAttribute("userData") UserInfo uObj, //request data is available in the UserInfo obj
			BindingResult result) {
		 //springs performs req capturing and springs keeps the req data inside UserInfo obj
		return new ModelAndView("showUserInput", "userObj",uObj);
	}
	
	/**
	 * @return
	 Req:
		input:
		firstname
		lastname
		email
		telephone
		age
		city
		gender
		idProofs
		address
		
	validate:
		Age should be between 18 and 60.
		telephone should be exactly 10 digits
		Invalid email syntax.
		
	what's adv of using
	a) Spring tags in jsp
	d) for every form there is a java class and
	  field name = instance variable name
	c)@ModelAttribute in controller class
	  
	 1.In controller request capturing and keep req data inside the obj is taken care by springs [submitted data from frontend to backend]
	 form to java obj
	 2.Preparing the web page using the java object.  [sending the obj from backend to frontend]
	 java obj to form 
	 */
	@RequestMapping(value = "/user2", method = RequestMethod.GET)
	public ModelAndView showUserForm2() {
		UserInfo userInfo = new UserInfo();
		userInfo.setFirstname("kumar");
		return new ModelAndView("user2", "userData",userInfo);
	}
	
	@RequestMapping(value = "/addUser2", method = RequestMethod.POST)
	public ModelAndView addUser2(
			@ModelAttribute("userData") UserInfo userInfoObj, //userInfoObj contains the input data submitted by customer
			BindingResult result) {
		int age = userInfoObj.getAge();
		int teleSize =userInfoObj.getTelephone().length();

		if(age<=18 || age>=60){
			String errorMsg ="Age should be between 18 and 60.";
			ModelAndView mObj  = new ModelAndView("user2");
			mObj.addObject("errorMsg", errorMsg);
			mObj.addObject("userData", userInfoObj);
			return mObj;
		}else if (teleSize!=10){
			String errorMsg ="telephone should be exactly 10 digits";
			ModelAndView mObj  = new ModelAndView("user2");
			mObj.addObject("errorMsg", errorMsg);
			mObj.addObject("userData", userInfoObj);
			return mObj;
		}else if (!userInfoObj.getEmail().contains("@") && !userInfoObj.getEmail().contains(".")){
			String errorMsg ="Invalid email syntax.";
			ModelAndView mObj  = new ModelAndView("user2");
			mObj.addObject("errorMsg", errorMsg);
			mObj.addObject("userData", userInfoObj);
			return mObj;
		}
		return new ModelAndView("showUserInput", "userObj",userInfoObj);	
	}

	//in validation if validation fails then we need to send the "error message" and "object" to the response page
	/**
	 Req:
		input:
			firstname
			lastname
			email
			telephone
			age
			city
			gender
			idProofs
			address
			
		validate and show all error messages at a time:
		Age should be between 18 and 60.
		telephone should be exactly 10 digits
		Invalid email syntax.
	 */
	@RequestMapping(value = "/user21", method = RequestMethod.GET)
	public ModelAndView showUser21() {
		return new ModelAndView("user21", "userData",new UserInfo());
	}
	
	@RequestMapping(value = "/addUser21", method = RequestMethod.POST)
	public ModelAndView addUser21(
			@ModelAttribute("userData") UserInfo userInfoObj,
			BindingResult result) {
		List<String> errors = service.validateUserInfo(userInfoObj);
		if(!errors.isEmpty()) {
			ModelAndView mObj  = new ModelAndView("user21");
			mObj.addObject("errors", errors);
			return mObj;
		}else {
			return new ModelAndView("showUserInput", "userObj",userInfoObj);
		}
	}

	@RequestMapping(value = "/user3", method = RequestMethod.GET)
	public ModelAndView showUserForm3() {
		return new ModelAndView("user3", "userData",new UserInfo());
	}
	
	/*
	 Req:
		input:
			firstname
			lastname
			email
			telephone
			age
			city
			gender
			idProofs
			address
			->telephone should be 10 chars.
		->firstname min 10 chars.
		->last name min 8 chars.
		->age between 18 and 60.
		
		validate and show   error message using exception handling
	
	1. Create Exception class
	2. throw Exception obj
	3.handle using try + catch
  
	1.when data is invalid throw the exception      -> service class
	2.catch the exception and handle the exception  -> controller class
		
		if validation is success then show response from showUserInput.jsp
		if validation is failure then show response from errorpage.jsp
		
		when exception is thrown then only the exception handling code is executed.
		write ExceptionHandler for every exception.
		the handlException method to return ModelAndView object.
		handlException method is called when there is an exception
		
	*/
	@RequestMapping(value = "/addUser3", method = RequestMethod.POST)
	public ModelAndView addUserWithValidation(
			@ModelAttribute("userData") UserInfo userInfoObj,
			BindingResult result) throws EmployeeException {
			service.processValidation(userInfoObj);
			return new ModelAndView("showUserInput", "userObj",userInfoObj);	
	}

	//exception handling logic for EmployeeException instead of try catch write below method
	@ExceptionHandler(EmployeeException.class)
	public ModelAndView handleEmployeeException( Exception ex){
		ModelAndView modelAndView = new ModelAndView("errorpage");
	    modelAndView.addObject("message", "error occured due to :"+ex.getMessage());
	    return modelAndView;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(
			HttpServletRequest request, Exception ex){
		ModelAndView modelAndView = new ModelAndView("ExceptionPage");
	    modelAndView.addObject("message", ex.getMessage());
	    return modelAndView;
	}
	//TODO : 404 exception handling
	
	/**
	 //req capturing + keep adat inside the java obj ===> Springs mvc using @ModelAttribute
 	 //validation is done by springs use validatr frameowrk ex: hiberante validator
 	 //write @Valid for the controller method ; before the form object
	 //in the form class for every instance variable write the validator annotations.
	 */
	
	//click on link on home.jsp
	/**
	Req:
	Validation on syntax for email and password on login page uisng validator framework

	New:
	------------
	1.use @Valid   in the controller method along with 	@ModelAttribute
	2. in the Pojo User.java
	use annotations for validations.
		@NotEmpty
		@Email
	   @NotEmpty(message = "Please enter your password.")
		@Size(min = 6, max = 15,message = "Your password must between 6 and 15 characters")
		
	 */
	@RequestMapping(value = "/validateLogin", method = RequestMethod.GET)
	public ModelAndView viewLogin() {
		return new ModelAndView("LoginForm", "userForm", new User());
	}

	//click on button on LoginForm.jsp
	@RequestMapping(value = "/validateLogin", method = RequestMethod.POST)
	public String doLogin(@Valid @ModelAttribute("userForm") User userForm, BindingResult result) {
		if (result.hasErrors()) {
			return "LoginForm";
		}
		return "LoginSuccess";
	}
		
		
	/**
	  ACTIVITY:
	- use code jsp   for jsp in another jsp
	-display all the  links in every page.
	
	1. create home.jsp in views
	2. in every jsp write 
		<jsp:include page="home.jsp"/>
	 */
	@RequestMapping(value = "/redirect1", method = RequestMethod.GET)
	public ModelAndView redirect1(HttpServletRequest req) {
		req.setAttribute("msg1", "hello from redirect");
		return new ModelAndView("forward:/redirect2");
	}
	
	//forward
	//redirect
	@RequestMapping(value = "/redirect2", method = RequestMethod.GET)
	public ModelAndView redirect2(HttpServletRequest req) {
		String myData = (String)req.getAttribute("msg1");
		return new ModelAndView("readDetails", "myData", myData);
	}
}