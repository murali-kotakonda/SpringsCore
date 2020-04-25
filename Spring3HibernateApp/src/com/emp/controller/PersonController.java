package com.emp.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {

	@RequestMapping("/getForm")
	public String readPersonInput(){
		return "personInput";
	}

	@RequestMapping(value="/person" , method= RequestMethod.GET)
	public ModelAndView readReq(
			@RequestParam("name") String name,
			@RequestParam("age") int age){
		String userData= "name = "+name + "-- age= "+age;
		return new ModelAndView("personOutput","userData",userData);
	}
	
	@RequestMapping(value="/person" , method= RequestMethod.POST)
	public ModelAndView readReqPost(
			@RequestParam("name") String name,
			@RequestParam("age") int age){
		String userData= "name = "+name + "-- age= "+age;
		return new ModelAndView("personOutput","userData",userData);
	}
	
	@RequestMapping(value="/user/{name}/{age}" , method= RequestMethod.GET)
	public ModelAndView readPathParams(
			@PathVariable("name") String name,
			@PathVariable("age") int age,
			HttpServletRequest req){
		String userData= "path data ==name = "+name + "-- age= "+age;
		return new ModelAndView("personOutput","userData",userData);
	}

	@RequestMapping("/getMultipleData")
	public String getMultiData(
		@RequestParam(value="name", required = true,defaultValue="user") String name,
			@RequestParam("age") int age,
			ModelMap model,HttpSession session, ServletContext context) {
		String userData= "path data ==name = "+name + "-- age= "+age;
		model.addAttribute("userData", userData);
		return "personOutput";
	}
}
