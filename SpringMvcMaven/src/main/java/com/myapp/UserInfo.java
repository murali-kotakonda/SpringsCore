package com.myapp;

import java.util.List;

public class UserInfo {
	private String firstname;    //	<form:input path="firstname" /> 
	private String lastname;   //	<form:input path="lastname" />
	private String email;   //	<form:input path="email" />
	private String telephone;   //	<form:input path="telephone" />
	private Integer age;   //	<form:input path="age" />
	private String city;    //	<form:input path="city" />
	  
	private String gender;   
	  //<form:radiobutton path="gender" value="Male" />
	  //<form:radiobutton path="gender" value="Female" />
	  
	private List<String> idProofs;  
	  //<form:checkbox path="idProofs" value="Voter"/>  
	  // <form:checkbox path="idProofs" value="Pan"/> 
	  //<form:checkbox path="idProofs" value="passport"/>  
	  
		private String  address;  
	  // <form:textarea path="address" />  
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<String> getIdProofs() {
		return idProofs;
	}
	public void setIdProofs(List<String> idProofs) {
		this.idProofs = idProofs;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}
