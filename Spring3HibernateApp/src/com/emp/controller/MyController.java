package com.emp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@RequestMapping(value="/hello" , method= RequestMethod.GET)
	public ModelAndView getHello() {
		String data = "Hi User get call !How are you!!";
		
		return new ModelAndView("response", "message", data);
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public ModelAndView postHello(ModelMap map) {
		String data = "Hi User Post call !How are you!!";
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("response");
		map.put("message", data);
		map.put("sal", 10000);
		
		return modelAndView;
	}

	@RequestMapping("/getRequestForm")
	public String showRequestPage(){
		return "request";
	}
	 	 
	@RequestMapping("/readName")
	public ModelAndView showEditEmp(
			@RequestParam("uName") String userName,
			@RequestParam("age") int age, 
			@RequestParam("sal") float sal) {
		String resData = "Hi " + userName + " , age = " + age + ", sal =" + sal;
		return new ModelAndView("readDetails", "myData", resData);
	}

	@RequestMapping(value="/readName" , method = RequestMethod.POST)
	public ModelAndView showEditEmpPost(
			@RequestParam("uName") String userName,
			@RequestParam("age") int age, 
			@RequestParam("sal") float sal) {
		String resData = "Hi " + userName + " , age = " + age + ", sal =" + sal;
		return new ModelAndView("readDetails", "myData", resData);
	}

	@RequestMapping(value="/readPathParams/{name}/{age}/{sal}" ,
			method = RequestMethod.GET)
	public ModelAndView readPathParam(
			@PathVariable("name") String userName,
			@PathVariable("age") int age, 
			@PathVariable("sal") float sal) {
		String resData = "Hi " + userName + " , age = " + age + ", sal =" + sal;
		return new ModelAndView("readDetails", "myData", resData);
	}

	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView checkLogin(@RequestParam("userName") String userName,
			@RequestParam("password") String password) {
		String resData = "";
		if (userName.equals(password)) {
			resData = "Login is Succes";
		} else {
			resData = "Login Failure due to invalid creds";
		}
		return new ModelAndView("response", "message", resData);
	}

	@RequestMapping(value = "/login")
	public ModelAndView checkGetLogin(
			@RequestParam("userName") String userName,
			@RequestParam("password") String password) {
		String resData = "";
		if (userName.equals(password)) {
			resData = "Login Succes";
		} else {
			resData = "Login Failure";
		}
		return new ModelAndView("response", "message", resData);
	}

	@RequestMapping("/helloEx")
	public ModelAndView getData2(HttpServletRequest request,
			HttpServletResponse res) {
		String data = "Hi How are you!!";
		return new ModelAndView("response", "message", data);
	}

	@RequestMapping("/getUser")
	public ModelAndView getData2() {
		String data = "getData2";
		return new ModelAndView("response", "message", data);
	}

	@RequestMapping("/getUserDetails")
	public ModelAndView getUserDetails(
			@RequestParam("name") String name,
			@RequestParam("password") String password) {
		//String name = request.getParameter("name");
		//String password = request.getParameter("password");

		if ("admin".equals(name) && "admin".equals(password)) {
			String message = "HELLO " + name;
			return new ModelAndView("hellopage", "userName", name);
		} else {
			return new ModelAndView("errorpage", "message",
					"Sorry, username or password error");
		}
	}
}
