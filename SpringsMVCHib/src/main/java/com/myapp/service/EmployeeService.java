package com.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.dao.EmployeeDao;
import com.myapp.dto.Employee;
import com.myapp.dto.EmployeeListResponse;
import com.myapp.util.ErrorEnum;
import com.myapp.util.UserException;

@Service("employeeService")
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	/**
	 this method is used for "Register" and "Add User" Scenarios.
	 */
	@Transactional
	public void addEmployee(Employee employee) throws UserException {
		if (employeeDao.isEmployeeExists(employee.getLoginName()))
			throw new UserException(ErrorEnum.ERRO4.getErrorCode(), ErrorEnum.ERRO4.getMsg());
		employeeDao.saveEmployee(employee);
	}

	@Transactional
	public Employee getEmpById(int id) {
		return employeeDao.getEmpById(id);
	}

	@Transactional
	public Employee getEmpByName(String name) {
		return employeeDao.searchByName(name);
	}

	@Transactional
	public Employee getValidEmpByAuth(Employee employee) {
		return employeeDao.getValidEmpByAuth(employee);
	}

	@Transactional
	public void updateEmployee(Employee employee) throws UserException {
		employeeDao.updateEmployee(employee);
	}

	@Transactional
	public List<Employee> getEmployees() {
		return employeeDao.getAllEmployees();
	}
	
	public EmployeeListResponse listEmployeess(int pageId) {
		return employeeDao.listEmployeess(pageId);
	}

	@Transactional
	public boolean deleteEmployee(Employee employee) {
		// check if the employee exists
		Employee empById = employeeDao.getEmpById(employee.getId());

		// if the employee doesnt exists then dont make db call, just return false;
		if (empById == null) {
			return false;
		}
		return employeeDao.deleteEmployee(employee);
	}
}