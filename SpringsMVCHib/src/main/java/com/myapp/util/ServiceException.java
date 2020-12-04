package com.myapp.util;

public class ServiceException extends Exception {

	 private   String errorCode;
	 
	 private ErrorEnum err;
	 
	 public ServiceException(ErrorEnum err) {
		super();
		this.err = err;
	}

	public ServiceException(String errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public ServiceException(String msg , String errorCode) {
		super(msg);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public ErrorEnum getErr() {
		return err;
	}

	public void setErr(ErrorEnum err) {
		this.err = err;
	}

	
}
