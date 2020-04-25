package com.mnp.dto;

public class Employee {
	//@Range(min = 18, max = 60)
	private Integer age;
	
	private Integer id;
	//@NotEmpty
	private String name;
	
	private String lName;
	
	private Integer salary;
	
	private Address address;
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Employee [age=" + age + ", id=" + id + ", name=" + name
				+ ", lName=" + lName + ", salary=" + salary + "]";
	}

	public Employee(Integer age, Integer id, String name, String lName, Integer salary) {
		super();
		this.age = age;
		this.id = id;
		this.name = name;
		this.lName = lName;
		this.salary = salary;
	}
	
	
	
}
