package com.mythri.exception;

public class EmployeeException extends RuntimeException {

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
