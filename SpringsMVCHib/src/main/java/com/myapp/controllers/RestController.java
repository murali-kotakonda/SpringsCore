package com.myapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.dto.Employee;
import com.myapp.dto.EmployeeResponse;
import com.myapp.dto.Info;
import com.myapp.service.EmployeeService;
import com.myapp.util.UserException;

/**

Assignment: provide validation logic for all web services.

Web-service provider :
-------------------------

1. Create the controller class

if the url contains /rest then it is a web-service call.
if the url does not contains /rest then it is a web applcation call.

Annotation for rest controller method
-----------------------------------------

1. for request URL AND HTTP_METHOD 
use @RequestMapping
EX:
@RequestMapping(value = "/employee", method = RequestMethod.POST)   -> Create employee
@RequestMapping(value = "/employee", method = RequestMethod.PUT)    -> update employee 
@RequestMapping(value = "/employee", method = RequestMethod.GET)    -> Get employee 
@RequestMapping(value = "/employee", method = RequestMethod.DELETE)  -> delete employee

2. for converting the request json/xml to  object use @RequestBody
3. for converting the response object to  json/xml use @ResponseBody 
4. For path param use @PathVariable("id")
5. for request param use @RequestParam("id") 


RestController.java:
-----------------------------
@Controller
@RequestMapping("/rest")
public class RestController {

	@Autowired
	private EmployeeService employeeService;
  
  
  }
	
- For testing web-service use "postman client"

Assignments:
-----------------
1. Provide the webservice for get employee by id using request param
1. Provide the webservice for delete employee by id using request param

*/

@Controller
@RequestMapping("/rest")
public class RestController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public @ResponseBody EmployeeResponse getEmps() {
		EmployeeResponse empResponse = new EmployeeResponse();
		empResponse.setStatus("SUCESSS");
		List<Employee> employees = employeeService.getEmployees();
		empResponse.setEmployees(employees);
		return empResponse ;
	}
	
	
		/**
		Get employee by ID:
		Resource url : /getEmpByIdParam
		http method: GET
		Response media: json
		query param: id=2000
		
		URL: <BASE_URL>/rest/getEmpByIdParam?id=2000
		
		for query param use @RequestParam("id") annotation
		
		 */
		@RequestMapping(value = "/getEmpByIdParam", method = RequestMethod.GET)
		public @ResponseBody EmployeeResponse getEmpByIdParam(@RequestParam("id") int id) {
			EmployeeResponse empResponse = new EmployeeResponse();
			
			Employee empById = employeeService.getEmpById(id);
			if (empById == null) {
				empResponse.setStatus("Employee id " + id + " not found");
				return empResponse;
			}
			empResponse.setStatus("SUCESSS");
			empResponse.getEmployees().add(empById);
			return empResponse;
		}
		
		/**
		<BASE_URL>/rest/getEmpByIdParam?id=2000  -> query params , 2000 is the emp  id
		<BASE_URL>/rest/getEmpByIdPathParam/2000     -> path param  , 2000 is the emp  id
		Get employee by ID using path param:
		Resource url : /getEmpByIdPathParam/{id}
		http method: GET
		Response media: json
		
		URL: <BASE_URL>/rest/getEmpByIdPathParam/2000
		
		for path param use @PathVariable("id") annotation
		
		 */
	
	@RequestMapping(value = "/getEmpByIdPathParam/{id}", method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody EmployeeResponse getEmpByIdPathParam(@PathVariable("id") int id) {
		EmployeeResponse empResponse= new EmployeeResponse();
		Employee empById = employeeService.getEmpById(id);
		if(empById==null) {
			empResponse.setStatus("Employee id "+id+" not found");
			return empResponse;
		}
		empResponse.setStatus("SUCESSS");
		empResponse.getEmployees().add(empById);
		return empResponse;
	}
	
 
	/**
		Actual URL : <BASE_URL>/rest/employee/{id}   
	    Delete employee by ID using path param:
		Resource url : /employee/{id}
		http method: DELETE
		Response media: json
	 */
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	public @ResponseBody  Info deleteEmpById(@PathVariable("id") int id) {
		Info info = new Info();
		
		//code for employee not found
		Employee empById = employeeService.getEmpById(id);
		if(empById==null) {
			info.setStatus("Employee id "+id+" not found");
			return info;
		}
		
		//code for employee found, call the delete employee
		Employee e = new Employee();
		e.setId(id);
		employeeService.deleteEmployee(e);
		
		info.setStatus("Employee "+id+" Deleted.");
		return info;
	}
	
	/**
	Actual URL : <BASE_URL>/rest/employee
	  
    Post employee ( Add new employee )
		Resource url : /employee 
		http method: POST
    Request Media Type :  application/json
    [Add header "Content-Type"  :  "application/json"]
    Request Body:
            {
            "name": "vamsi",
            "id": 1,
            "password": "123456789",
            "email": "vamsi@hotmail.com",
            "age": 30,
            "loginName": "LOKESH",
            "lName": "k",
            "salary": 60000.0
        },
    
		Response Media Type : json
    
    
    As there is a Request body we need to use @RequestBody.
    As there is a Response body we need to use @ResponseBody.
    
      The json string is converted to Employee object using @RequestBody.
	 */
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public @ResponseBody Info createEmployee(@RequestBody Employee emp) {
		Info info= new Info();
		
		try {
			employeeService.addEmployee(emp);
		} catch (UserException e) {
			String msg = e.getMessage();
			info.setStatus(msg);
			return info;
		}
		
		info.setStatus("Employee Created!");
		return info;
	}

			/**
			Actual URL : <BASE_URL>/rest/employee
		  
			PUT employee ( Update existing employee )
			Resource url : /employee 
			http method: PUT
			Request Media Type :  application/json
				[Add header "Content-Type"  :  "application/json"]
			Request Body:
		        {
		        "name": "vamsi",
		        "id": 1,
		        "password": "123456789",
		        "email": "vamsi@hotmail.com",
		        "age": 30,
		        "loginName": "LOKESH",
		        "lName": "k",
		        "salary": 60000.0
		    }
		
			Response Media Type : json
		
		 	As there is a Request body we need to use @RequestBody.
			As there is a Response body we need to use @ResponseBody.
		
			The json string is converted to Employee object using @RequestBody.
		 */
	@RequestMapping(value = "/employee", method = RequestMethod.PUT)
	public @ResponseBody Info updateEmployee(@RequestBody Employee emp) {
		Info  info = new Info();
		
		//validate the id
		Integer id = emp.getId();
		Employee empById = employeeService.getEmpById(id);
		if(empById==null) {
			info.setStatus("Employee id "+id+" not found");
			return info;
		}
		
		//update the employee
		try {
			employeeService.updateEmployee(emp);
		} catch (UserException e) {
			String msg = e.getMessage();
			info.setStatus(msg);
			return info;
		}
		info.setStatus("Employee upated!");
		return info;
	}
	
	

	
}
