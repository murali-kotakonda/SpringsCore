package com.mnp.emp.exception;

public class EmployeeException extends Exception {

	private static final long serialVersionUID = -4794572499177930357L;
	
	private String exceptionMsg;
	 
	public EmployeeException(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
	
	public String getExceptionMsg(){
		return this.exceptionMsg;
	}
	
	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
}
