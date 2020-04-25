package com.emp.dao;

import com.emp.model.Employee;
import com.emp.model.EmployeeResponse;
 
public interface EmployeeDao {
	
	public void addEmployee(Employee employee);

	public EmployeeResponse listEmployeess(int pageId);
	
	public Employee getEmployee(int empid);
	
	public void deleteEmployee(Employee employee);

	public EmployeeResponse listEmployeess();
}
