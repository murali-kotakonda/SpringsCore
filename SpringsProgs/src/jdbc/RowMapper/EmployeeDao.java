package jdbc.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}

	public List<Employee> getAllEmployeesUsingRowMapper() {
		return jdbcTemplate.query("select * from employee",
				new RowMapper<Employee>() {
					public Employee mapRow(ResultSet rs, int rownumber)
							throws SQLException {
						Employee e = new Employee();
						e.setId(rs.getInt(1));
						e.setName(rs.getString(2));
						e.setSalary(rs.getLong(3));
						return e;
					}
				});
	}
	
	public List<Employee> getAllEmployeeUsingResultSet(){  
		 return jdbcTemplate.query("select * from employee",
				 new ResultSetExtractor<List<Employee>>(){  
		     public List<Employee> extractData(ResultSet rs)
		    		 throws SQLException,  
		            DataAccessException {  
		      
		        List<Employee> list=new ArrayList<Employee>();  
						while (rs.next()) {
							Employee e = new Employee();
							e.setId(rs.getInt(1));
							e.setName(rs.getString(2));
							e.setSalary(rs.getInt(3));
							list.add(e);
						}  
		        return list;  
		        }  
		    });  
		  }  
}