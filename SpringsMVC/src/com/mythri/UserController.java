package com.mythri;

import java.util.ArrayList;
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

import com.mnp.dto.User;
import com.mythri.exception.EmployeeException;


@Controller
public class UserController {
	
	@Autowired
	RegisterService service;
//
	/*
	request capturing + keep req data inside the obj becomes complex/more lines of code when 
	we have many fields coming from the web page
	Requirement:
------------------
capture the followin info from the web page
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
  Contrller class  + method
  Pojo class : UserInfo.java
  
  
In web page use  : spring tags
In java -> instead of @RequestParam use @ModelAttribute

1. convert the web form data to the java obj  [ client ---> server]
2. Using the java obj prepare the form [serevr --> client]

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
	
	@RequestMapping(value = "/user2", method = RequestMethod.GET)
	public ModelAndView showUserForm2() {
		return new ModelAndView("user2", "userData",new UserInfo());
	}
	
	@RequestMapping(value = "/addUser2", method = RequestMethod.POST)
	public ModelAndView addUser2(
			@ModelAttribute("userData") UserInfo userInfoObj,
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
		
1.when data is invalid throw the exception      -> service class
2.catch the exception and handle the exception  -> controller class
	  
		->telephone should be 10 chars
		->firstname min 10 chars
		->last name min 8 chars
		->age between 18 and 60
	 * */
	@RequestMapping(value = "/addUser3", method = RequestMethod.POST)
	public ModelAndView addUserWithValidation(
			@ModelAttribute("userData") UserInfo userInfoObj,
			BindingResult result) throws EmployeeException {
			service.processValidation(userInfoObj);
			return new ModelAndView("showUserInput", "userObj",userInfoObj);	
	}
	/*
	//write ExceptionHandler for every exception.
	//the handleexception method to return ModelAndView object.
	//handleexception methos is called when there is an exception
	
	 **/
	@ExceptionHandler(EmployeeException.class)
	public ModelAndView handleEmployeeException(
			HttpServletRequest request, Exception ex){
		ModelAndView modelAndView = new ModelAndView("errorpage");
	    modelAndView.addObject("message", ex.getMessage());
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
	
	@RequestMapping(value = "/validateLogin", method = RequestMethod.GET)
	public ModelAndView viewLogin() {
		return new ModelAndView("LoginForm", "userForm", new User());
	}

	@RequestMapping(value = "/validateLogin", method = RequestMethod.POST)
	public String doLogin(
			@Valid 
			@ModelAttribute("userForm") User userForm,
			BindingResult result) {
		if (result.hasErrors()) {
			return "LoginForm";
		}
		return "LoginSuccess";
	}
	
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
