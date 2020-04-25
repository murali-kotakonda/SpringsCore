package com.mythri.controllers;

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

import com.mythri.dto.Employee;
import com.mythri.service.EmployeeService;
import com.mythri.util.EmployeeNotFoundException;
import com.mythri.util.UserException;

@Controller
public class EmployeeController {

	private static final String MSG = "msg";

	private static final String EMP = "emp";

	public static final String COMMAND = "command";

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private MessageSource messageSource;

	@RequestMapping("/addEmp")
	public ModelAndView showAddEmp() {
		Employee employee = new Employee();
		return new ModelAndView("showAddEmp", "command", employee);
	}

	@RequestMapping(value = "/addEmp", method = RequestMethod.POST)
	public ModelAndView addEmp(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
		if (result.hasErrors()) {
			String message = getErrorMsg(result);
			ModelAndView model = new ModelAndView("showAddEmp", "command", employee);
			model.addObject(MSG, message);
			return model;
		}

		try {
			employeeService.addEmployee(employee);
		} catch (UserException e) {
			String msg = e.getMessage();
			ModelAndView modelAndView = new ModelAndView("showAddEmp", COMMAND, employee);
			modelAndView.addObject(MSG, msg);
			return modelAndView;
		}
		ModelAndView model = new ModelAndView("showEmp", EMP, employee);
		model.addObject(MSG, "Employee Created!");
		return model;
	}

	@RequestMapping("/readUser")
	public String showGetEmp() throws Exception {
		return "readUser";
	}
	
	@RequestMapping(value="/readUser", method=RequestMethod.POST)
	public ModelAndView getEmpById(@RequestParam("id") int empId)  throws Exception{
		Employee employee = employeeService.getEmpById(empId);
		ModelAndView modelAndView = new ModelAndView("readUser");
		if(employee==null){
			modelAndView.addObject(MSG,"Employee Not found");
		}else{
			modelAndView.addObject(EMP,employee);
		}
		return modelAndView;
	}
	/*
	 
		-> first we need to click on edit Link on the "show All Emps" response page
		-> The edit link should carry the emp Id of the employee we want to edit
		we have to add the Edit Link for every employee in the response page.
		  ex: <a href="./editEmp?empId=${emp.id}">Edit</a>
		
		 
		 
		1. Show the current existing data of the employee when we click on edit link.
		  The form will contain hidden form fields for id + loginame [not visisble to customer]
		  On click of "Update Emp" button id + loginname+fn+ln+email+age+salary is submitted to the backend.
		    
		2.On click of "Update Emp" , the new data should be updated for the employee...... 
		     

     
	 */
	@RequestMapping("/editEmp")
	public ModelAndView showEditEmp(@RequestParam("empId") int empId) {
		Employee emp = employeeService.getEmpById(empId);
		return new ModelAndView("showEditEmp", "command", emp);
	}
	
	@RequestMapping(value = "/editEmp", method = RequestMethod.POST)
	public ModelAndView updateEmp(
			@Valid @ModelAttribute("employee") Employee employee, 
			BindingResult result) {
		if (result.hasErrors()) {
			String message = getErrorMsg(result);
			ModelAndView model = new ModelAndView("showEditEmp", "command", employee);
			model.addObject(MSG, message);
			return model;
		}

		try {
			employeeService.updateEmployee(employee);
			ModelAndView modelAndView = new ModelAndView("showEmp", "emp", employee);
			modelAndView.addObject(MSG,"update successful!!");
			return modelAndView;
		} catch (UserException e) {
			String msg = e.getMessage();
			ModelAndView modelAndView = new ModelAndView("showEditEmp", COMMAND, employee);
			modelAndView.addObject(MSG, msg);
			return modelAndView;
		}
	}
	
	@RequestMapping("/deleteEmp")
	public String showDeleteEmp()  throws Exception{
		return "deleteUser";
	}
	
	@RequestMapping(value="/deleteEmp", method=RequestMethod.POST)
	public ModelAndView deleteEmp(@RequestParam("id") int userId,HttpSession session)  throws Exception{
		Integer myId = (Integer)session.getAttribute("myId");
		if(myId==userId) {
			return new ModelAndView("deleteUser", "messageInfo", "You cannot delete your Profile..");
		}
		Employee emp = new Employee();
		emp.setId(userId);
		boolean status = employeeService.deleteEmployee(emp);
		if(!status){
			return new ModelAndView("deleteUser", "messageInfo", "Employee Id Not found.");
		}
		return new ModelAndView("deleteUser", "messageInfo", "Deleted successfully");
	}

	@RequestMapping("/getAllEmps")
	public ModelAndView getAllEmps() {
		List<Employee> emps =employeeService.getEmployees();
		return new ModelAndView("showEmps", "emps", emps);
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
