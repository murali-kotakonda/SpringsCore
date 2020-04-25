package com.mythri.util;

public enum ErrorEnum {

	ERRO1("ERRO1" ,"INVALID AGE"),
	ERRO2( "ERRO2","CITY SHOULD BE BANGLORE"),
	ERRO3( "ERRO3","userType should be admin"),
	ERRO4( "ERRO4","user already exist");

	private String errorCode;
	private String msg;
	
	private ErrorEnum(String errorCode, String msg) {
		this.errorCode = errorCode;
		this.msg = msg;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public String getMsg() {
		return msg;
	}
}
