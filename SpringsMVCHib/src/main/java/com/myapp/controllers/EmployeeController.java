package com.myapp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myapp.dto.Employee;
import com.myapp.service.EmployeeService;
import com.myapp.util.EmployeeNotFoundException;
import com.myapp.util.UserException;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private MessageSource messageSource;

	/**
	Req:
	logined user can also create a employee using the "Add Emp" link.
	1.click on "Add Emp" Link     --> need a controller method
	show the add employe form
	
	2.Fill the data for fName, lname, age ,email , salary, loginname , password
	and click on "Add employee" Button  --> need a controller method
	 */
	
	 //controller method for click on "Add Emp" Link and show response using "showAddEmp.jsp"
	@RequestMapping("/addEmp")
	public ModelAndView showAddEmpByUser() {
		Employee employee = new Employee();
		return new ModelAndView("showAddEmp", "command", employee);
	}

	/**
	   controller method customer  clicks on "Add Emp" Button and
	   If success show response using "showEmp.jsp"
	    If failure show response with error msg using "showAddEmp.jsp"
	    emp.jsp is reused for "My Profile" and "Add User" (Success) scenarios.
	 */
	@RequestMapping(value = "/addEmp", method = RequestMethod.POST)
	public ModelAndView addEmpByUser(@Valid 
			@ModelAttribute("employee") 
			Employee employee, BindingResult result) {
		if (result.hasErrors()) {
			String message = "Error while creating emp";//getErrorMsg(result);
			ModelAndView model = new ModelAndView("showAddEmp", "command", employee);
			model.addObject("msg", message);
			return model;
		}
		try {
			employeeService.addEmployee(employee);
		} catch (UserException e) {
			String msg = e.getMessage();
			ModelAndView modelAndView = new ModelAndView("showAddEmp", "command", employee);
			modelAndView.addObject("msg", msg);
			return modelAndView;
		}
		ModelAndView model = new ModelAndView("showEmp", "emp", employee);
		model.addObject("msg", "Employee Created!");
		return model;
	}

	 /*controller method when customer clicks on "show all users" link
	   show response using showEmps.jsp
	  url writing:
	 -----------------------
	  <a href="./editEmp?empId=${emp.id}">Edit</a></td>
	  we are using then url rewriting for sending the dynamic data along with the url
	  */
	@RequestMapping("/getAllEmps")
	public ModelAndView getAllEmps() {
		List<Employee> emps = employeeService.getEmployees();
		return new ModelAndView("showEmps", "emps", emps);
	}
	
	//controller method when customer clicks on "search emp" link
	@RequestMapping("/readUser")
	public String showGetEmp() throws Exception {
		return "readUser";
	}
	
	/**
	 controller method when customer clicks on "search" Button
	  as there is a input for id use @RequestParam
   		show response using readUser.jsp 
        if id is valid  show show empl details
    	if id is invalid show "Employee Not found"
	 */
	@RequestMapping(value="/readUser", method=RequestMethod.POST)
	public ModelAndView getEmpById(@RequestParam("id") int empId)  throws Exception{
		Employee employee = employeeService.getEmpById(empId);
		ModelAndView modelAndView = new ModelAndView("readUser");
		if(employee==null){
			modelAndView.addObject("msg","Employee Not found");
		}else{
			modelAndView.addObject("emp",employee);
		}
		return modelAndView;
	}
	
	//controller method when customer clicks on "delete emp" link
	@RequestMapping("/deleteEmp")
	public String showDeleteEmp()  throws Exception{
		return "deleteUser";
	}
	
	/**
	 controller method when customer clicks on "delete Emp" Button
	  as there is a input for id use @RequestParam
  	  show response using deleteUser.jsp "Deleted successfully"
   	  if id is invalid show "Employee id Not found"
	 */
	@RequestMapping(value="/deleteEmp", method=RequestMethod.POST)
	public ModelAndView deleteEmp(@RequestParam("id") int userId )  throws Exception{
		Employee emp = new Employee();
		emp.setId(userId);
		boolean status = employeeService.deleteEmployee(emp);
		if(!status){
			return new ModelAndView("deleteUser", "messageInfo", "Employee Id Not found.");
		}
		return new ModelAndView("deleteUser", "messageInfo", "Deleted successfully");
	}
	/*
		-> first we need to click on edit Link on the "show All Emps" response page
		-> The edit link should carry the emp Id of the employee we want to edit
		we have to add the Edit Link for every employee in the "show All Emps"  response page.
		  ex: <a href="./editEmp?empId=${emp.id}">Edit</a>
		 
		 Flow#1:[ show curr data]
		1. Show the current existing data of the employee when we click on edit link.
		Customer can edit fn,ln ,email ,age ,salary.
        Hidden form fields for id + loginame
		The form will contain hidden form fields for id + loginame [not visible to customer]
		On click of "Update Emp" button id + loginname+fn+ln+email+age+salary is submitted to the backend.
		    
		2.On click of "Update Emp" , the new data should be updated for the employee...... 
	 */
	//method to show curr emp data based on emp id
	@RequestMapping("/editEmp")
	public ModelAndView showEditEmp(@RequestParam("empId") int empId) {
		Employee emp = employeeService.getEmpById(empId);
		return new ModelAndView("showEditEmp", "command", emp);
	}
	
	
	/**
	 controller method to update employee .
	 On click of "Update Emp" , the new data should be updated for the employee......
	 
	 once update is success show "showEmp.jsp"
	 */
	@RequestMapping(value = "/editEmp", method = RequestMethod.POST)
	public ModelAndView updateEmp(
			@Valid @ModelAttribute("employee") Employee employee, 
			BindingResult result) {
		if (result.hasErrors()) {
			String message = getErrorMsg(result);
			ModelAndView model = new ModelAndView("showEditEmp", "command", employee);
			model.addObject("msg", message);
			return model;
		}
		try {
			employeeService.updateEmployee(employee);
			ModelAndView modelAndView = new ModelAndView("showEmp", "emp", employee);
			modelAndView.addObject("msg","update successful!!");
			return modelAndView;
		} catch (UserException e) {
			String msg = e.getMessage();
			ModelAndView modelAndView = new ModelAndView("showEditEmp", "command", employee);
			modelAndView.addObject("msg", msg);
			return modelAndView;
		}
	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ModelAndView handleEmployeeNotFoundException(HttpServletRequest request, Exception ex){
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exception", ex);
	    modelAndView.addObject("url", request.getRequestURL());
	    
	    modelAndView.setViewName("error");
	    return modelAndView;
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
