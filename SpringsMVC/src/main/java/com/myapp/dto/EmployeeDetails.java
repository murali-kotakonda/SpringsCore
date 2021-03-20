package com.myapp.dto;

public class EmployeeDetails {
	private Integer age;
	
	private Integer id;
	private String name;
	
	private String lName;
	
	private Integer salary;
	
	public EmployeeDetails() {
		super();
	}

	public EmployeeDetails(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EmployeeDetails(Integer age, Integer id, String name, String lName, Integer salary) {
		super();
		this.age = age;
		this.id = id;
		this.name = name;
		this.lName = lName;
		this.salary = salary;
	}
	
	
	
}
