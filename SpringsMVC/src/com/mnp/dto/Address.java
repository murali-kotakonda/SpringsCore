package com.mnp.dto;

public class Address {
	private String hno;
	private String pinCode;
	private String city;
	private String state;
	private String country;
	public String getHno() {
		return hno;
	}
	public void setHno(String hno) {
		this.hno = hno;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Address(String hno, String pinCode, String city, String state,
			String country) {
		super();
		this.hno = hno;
		this.pinCode = pinCode;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
	
}
