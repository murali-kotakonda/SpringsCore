package com.myapp.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,
reason="Employee Not Found") //404
public class EmployeeNotFoundException extends Exception {


	public EmployeeNotFoundException(int id){
		super("EmployeeNotFoundException with id="+id);
	}
}
