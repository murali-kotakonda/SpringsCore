package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mnp.dto.Employee;
import com.mnp.util.EmployeeNotFoundException;

@Controller
public class EmployeeController {
	
	@Autowired
	EmpService empService;

	@RequestMapping("/showDeleteEmp")
	public String showDeleteEmp()  throws Exception{
		return "deleteUser";
	}
	
 	@RequestMapping("/deleteEmp")
	public ModelAndView deleteEmp(@RequestParam("id") int userId)  throws Exception{
		Employee emp = new Employee();
		emp.setId(userId);
		boolean result = empService.deleteEmployee(emp);
		if(!result)
			throw new EmployeeNotFoundException(""+userId);
		return new ModelAndView("deleteUser", "messageInfo", "Deleted successfully");
	}
	
	@RequestMapping("/showAddEmp")
	public ModelAndView showAddEmp() {
		Employee employee = new Employee();
		return new ModelAndView("showAddEmp", "command", employee);
	}
	
	@RequestMapping(value = "/AddEmp", method = RequestMethod.POST)
	public ModelAndView addEmp(
			@ModelAttribute("employee") Employee employee, 
			BindingResult result) {
		empService.saveEmployee(employee);
		return new ModelAndView("showEmp", "emp", employee);
	}
	
	@RequestMapping("/showGetEmp")
	public String showGetEmp()  throws Exception{
		return "readUser";
	}
	
	@RequestMapping("/showEditEmp")
	public ModelAndView showEditEmp(
			@RequestParam("empId") int empId) {
		Employee emp =  empService.getEmpById(empId);
		return new ModelAndView("showEditEmp", "command", emp);
	}
	
	@RequestMapping(value = "/UpdateEmp", method = RequestMethod.POST)
	public ModelAndView UpdateEmp(@ModelAttribute("employee") Employee employee, BindingResult result) {
		empService.updateEmployee(employee);
		return new ModelAndView("showEmp", "emp", employee);
	}
	
 	@RequestMapping("/getEmpById")
	public ModelAndView getEmpById(@RequestParam("id") int empId)  throws Exception{
		Employee emp = empService.getEmpById(empId);
		return new ModelAndView("showEmp", "emp", emp);
	}
	
	@RequestMapping("/getAllEmps")
	public ModelAndView getAllEmps() {
		List<Employee> emps =empService.getAllEmployees();
		return new ModelAndView("showEmps", "emps", emps);
	}
}