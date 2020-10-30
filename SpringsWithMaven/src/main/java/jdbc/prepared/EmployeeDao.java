package jdbc.prepared;

import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

public class EmployeeDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Boolean saveEmployee(final Employee e) {
		String query = "insert into employee values(?,?,?)";
		
		return jdbcTemplate.execute(query,
				new PreparedStatementCallback<Boolean>() {
					public Boolean doInPreparedStatement(PreparedStatement ps)
							 {
						try {
							ps.setInt(1, e.getId());
							ps.setString(2, e.getName());
							ps.setLong(3, e.getSalary());
							return ps.execute();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						return false;
					}
				});
	}

}