package com.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mnp.dto.Employee;

@Repository("empDao")
public class EmpDao {

	@Autowired
	JdbcTemplate template;
	
	String tableName = "user_Info";

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public List<Employee> getAllEmployees() {
		//query
		String query = "select * from " + tableName;
		
		//rowMapperObj 
		RowMapper<Employee> rowMapperObj = new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int rownumber) throws SQLException {
				return getEmployee(rs);
			}
		};
		
		//call the query method
		return template.query(query, rowMapperObj);
	}
	
	public Boolean saveEmployee(final Employee e) {
		String query = "insert into " + tableName + " values(?,?,?,?,?)";
		return template.update(query,
				new Object[] { getLatestId(e), e.getName(), e.getlName(), e.getAge(), e.getSalary() }) > 0;
	}

	public boolean updateEmployee(final Employee e) {
		String query = "update " + tableName + " set fname=?,lname=?,age=?,sal=? where id=?";
		return template.update(query,
				new Object[] { e.getName(), e.getlName(), e.getAge(), e.getSalary(), e.getId() }) > 0;
	}

	public boolean deleteEmployee(final Employee e) {
		String query = "delete from " + tableName + " where id=?";
		return template.update(query, new Object[] { e.getId() }) > 0;
	}

	public int getLatestId(Employee e) {
		String query = "select max(id) from " + tableName;
		int maxId = template.queryForInt(query, new Object[] {});
		if(maxId==0){
			maxId=2000;
		}
		maxId++;
		e.setId(maxId);
		return maxId ;
	}
	
	public Employee getEmpById(int id) {
		//query
		String sql = "select * from " + tableName + " where id='" + id + "'";
		
       // create resultSetObj 
		ResultSetExtractor<Employee> resultSetObj = new ResultSetExtractor<Employee>() {
			public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
				Employee e = null;
				if (rs.next()) {
					e = getEmployee(rs);
				}
				return e;
			}
		};
		
		//call query method
		return template.query(sql,resultSetObj);
	}

	 //convert row to java object
	private Employee getEmployee(ResultSet rs) throws SQLException {
		Employee e = new Employee();
		e.setId(rs.getInt("ID"));
		e.setName(rs.getString("FNAME"));
		e.setlName(rs.getString("LNAME"));
		e.setAge(rs.getInt("AGE"));
		e.setSalary(rs.getInt("SAL"));
		return e;
	}
}