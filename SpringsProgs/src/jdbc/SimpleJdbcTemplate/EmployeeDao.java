package jdbc.SimpleJdbcTemplate;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class EmployeeDao {
	SimpleJdbcTemplate simpleTemplate;

	public SimpleJdbcTemplate getSimpleTemplate() {
		return simpleTemplate;
	}


	public void setSimpleTemplate(SimpleJdbcTemplate simpleTemplate) {
		this.simpleTemplate = simpleTemplate;
	}


	public int update(Employee e) {
		String query = "insert into employee values(?,?,?)";
		return simpleTemplate.update(query,e.getId(), e.getName(), e.getSalary());
		// String query="update employee set name=?,salary=? where id=?";
		// return template.update(query,e.getName(),e.getSalary(),e.getId());
	}

}