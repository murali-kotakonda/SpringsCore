package com.emp.service;

import com.emp.model.Employee;
import com.emp.model.EmployeeResponse;

public interface EmployeeService {
	
	public void addEmployee(Employee employee);

	public EmployeeResponse listEmployeess(int pageId);
	
	public Employee getEmployee(int empid);
	
	public void deleteEmployee(Employee employee);

	public EmployeeResponse listEmployeess();
}
