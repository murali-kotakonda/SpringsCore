package jdbc.NamedParameterJdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class EmployeeDao {
	NamedParameterJdbcTemplate template;


	public NamedParameterJdbcTemplate getTemplate() {
		return template;
	}


	public void setTemplate(NamedParameterJdbcTemplate template) {
		this.template = template;
	}


	public void save(Employee e) {
		String query = "insert into employee values " +
				"(:myid,:name,:salary)";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("myid", e.getId());
		map.put("name", e.getName());
		map.put("salary", e.getSalary());
		 
		template.execute(query, map, new PreparedStatementCallback() {
			public Object doInPreparedStatement(
					PreparedStatement preparedSt)
					throws SQLException, DataAccessException {
				return preparedSt.executeUpdate();
			}
		});
	}
}