package com.mythri;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mnp.dto.Employee;
import com.mythri.util.EmployeeNotFoundException;

@Controller
public class MockEmployeeController {

	static Set<Employee> emps = new LinkedHashSet<Employee>();
	
	static{
		for(int i =1;i<=10;i++){
			emps.add(new Employee(2000+i,"testUser"+i));
		}
	}

	@RequestMapping("/getAllEmps")
	public ModelAndView getAllEmps() {
		return new ModelAndView("showEmps", "emps", emps);
	}

	@RequestMapping(value = "/AddEmp", method = RequestMethod.POST)
	public ModelAndView addEmp(
			@ModelAttribute("employee") Employee employee,
			BindingResult result) {
		String jspName ="showEmp";
		ModelAndView mv = new ModelAndView();
		if (employee.getName().length() < 5) {
			jspName = "showAddEmp";
			mv.addObject( "command", employee);
			mv.addObject("msg","Name should be > 5 chars");
		}
		else if (employee.getAge() < 18) {
			jspName = "showAddEmp";
			mv.addObject( "command", employee);
			mv.addObject("msg","age should be > 18");
		}else{
			mv.addObject( "emp", employee);
		}
		emps.add(employee);
		mv.setViewName(jspName);
		return mv ;
	}
	
	@RequestMapping("/showAddEmp")
	public ModelAndView showAddEmp() {
		Employee employee = new Employee();
		return new ModelAndView("showAddEmp", "command", employee);
	}
	
	/*@Valid 
	 * if (result.hasErrors()) {
	return new ModelAndView("showAddEmp", "command", employee);
} else {
	if(employee.getName().length() < 5 ){
         throw new EmployeeException("Given name is too short");
    }
	if( employee.getAge() < 18 ){
		throw new EmployeeException("Given age is too low");
	}
	*/
	
	@RequestMapping("/showGetEmp")
	public String showGetEmp()  throws Exception{
		return "readUser";
	}
	
	@RequestMapping("/getEmpById")
	public ModelAndView getEmpById(@RequestParam("id") int empId) {
		Employee emp = getEmpId(empId);
		if(emp==null){
			return new ModelAndView("readUser", "messageInfo", "EmpId not found");
		}else{
			return new ModelAndView("showEmp", "emp", emp);	
		}
	}
	
	private Employee getEmpId(int empId) {
		for (Employee e : emps) {
			if (e.getId() == empId)
				return e;
		}
		return null;
	}

	@RequestMapping("/showEditEmp")
	public ModelAndView showEditEmp(
			@RequestParam("empId") int empId) {
		Employee emp =  getEmpId(empId);
		return new ModelAndView("showEditEmp", "command", emp);
	}
	
	@RequestMapping(value = "/UpdateEmp", method = RequestMethod.POST)
	public ModelAndView updateEmp(
			@ModelAttribute("employee") Employee employee,
			BindingResult result)  {
		String jspName ="showEmp";
		ModelAndView mv = new ModelAndView();
		if (employee.getName().length() < 5) {
			jspName = "showEditEmp";
			mv.addObject( "command", employee);
			mv.addObject("msg","Name should be > 5 chars");
		}
		else if (employee.getAge() < 18) {
			jspName = "showEditEmp";
			mv.addObject( "command", employee);
			mv.addObject("msg","age should be > 18");
		}else{
			mv.addObject( "emp", employee);
		}
		emps.add(employee);
		mv.setViewName(jspName);
		return mv ;
	}
	
	/*if(employee.getName().length() < 5 ){
        throw new EmployeeException("Given name is too short");
   }*/
	/*	if(emp==null)
	throw new EmployeeNotFoundException(userId);*/
	
	@RequestMapping("/showDeleteEmp")
	public String showDeleteEmp()  throws Exception{
		return "deleteUser";
	}
	
	@RequestMapping("/deleteEmp")
	public ModelAndView deleteEmp(@RequestParam("id") int userId)  {
		Employee emp = new Employee();
		emp.setId(userId);
		boolean result = deleteEmp(emp);
		if(result)
			return new ModelAndView("deleteUser", "messageInfo", "Deleted successfully");
		else{
			return new ModelAndView("deleteUser", "messageInfo", "EmpId not found");	
		}
	}

	private boolean deleteEmp(Employee emp) {
		return emps.remove(emp);
	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ModelAndView handleEmployeeNotFoundException(HttpServletRequest request, Exception ex){
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exception", ex);
	    modelAndView.addObject("url", request.getRequestURL());
	    
	    modelAndView.setViewName("error");
	    return modelAndView;
	}
	
	/*@ModelAttribute("employee")
    public Employee getUserObject() {
        return new Employee();
    }
*/	
}
