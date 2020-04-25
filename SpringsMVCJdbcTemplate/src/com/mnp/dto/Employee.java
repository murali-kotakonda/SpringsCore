package com.mnp.dto;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class Employee {
	
	private Integer id;
	
	@NotEmpty
	private String name;
	
	private String lName;
	
	private Integer salary;
	
	@Range(min = 18, max = 60)
	private Integer age;
	
	public Employee() {
		super();
	}

	public Employee(int id, String name) {
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

	@Override
	public String toString() {
		return "Employee [age=" + age + ", id=" + id + ", name=" + name
				+ ", lName=" + lName + ", salary=" + salary + "]";
	}
}
