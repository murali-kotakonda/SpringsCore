package com.mnp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.mnp.dto.Employee;

public interface Dao {

	public Boolean saveEmployee(final Employee e);
	
	public boolean updateEmployee(final Employee e) ;

	public boolean deleteEmployee(final Employee e) ;
	
	public List<Employee> getAllEmployees() ;
	
	public Employee getEmpById(int id);
}
