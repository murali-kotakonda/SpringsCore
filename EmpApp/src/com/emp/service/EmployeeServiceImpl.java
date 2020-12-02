package com.emp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.emp.dao.EmployeeDao;
import com.emp.model.Employee;
import com.emp.model.EmployeeResponse;
 
@Service("employeeService")
//@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}


	@Override
	public EmployeeResponse listEmployeess() {
		return employeeDao.listEmployeess();
 	}
	
	
	
	
	
	public EmployeeResponse listEmployeess(int pageId) {
		return employeeDao.listEmployeess(pageId);
	}

	public Employee getEmployee(int empid) {
		return employeeDao.getEmployee(empid);
	}
	
	public void deleteEmployee(Employee employee) {
		employeeDao.deleteEmployee(employee);
	}



}
