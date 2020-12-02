package com.mnp.emp.exception;

//@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Employee Not Found") //404
public class EmployeeNotFoundException extends Exception {

	private String msg;
	
	public String getMsg() {
		return msg;
	}

	public EmployeeNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	public EmployeeNotFoundException(String msg, int id ){
		super("EmployeeNotFoundException with id="+id);
		this.msg= msg;
	}
}
