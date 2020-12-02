package jdbc;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestReadAllEmps {
	public static void main(String[] args) throws SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/jdbc/springs.xml");
		EmployeeDao dao = (EmployeeDao) context.getBean("empDao");

		ResultSet rs1 = dao.getResultSet();
		ResultSet rs2 = dao.getResultSet();
		compare(rs1, rs2);

	}

	public static void compare(ResultSet rs1, ResultSet rs2) throws SQLException {
		List<String> columns1 = getColumns(rs1);
		List<String> columns2 = getColumns(rs2);
		System.out.println("compare resultsets");
		printDifference("table1", columns1, columns2);
		printDifference("table2", columns2, columns1);
	}

	public static List<String> getColumns(ResultSet rs) throws SQLException {
		List<String> columns = new ArrayList<String>();
		ResultSetMetaData rsMetaData = rs.getMetaData();
		int numberOfColumns = rsMetaData.getColumnCount();

		for (int i = 1; i < numberOfColumns + 1; i++) {
			String columnName = rsMetaData.getColumnName(i);
			columns.add(columnName);
		}
		return columns;
	}

	private static void printDifference(String from, List<String> dbColumns, List<String> excelColumns) {
		List<String> missing = new ArrayList<String>();
		excelColumns.forEach(data -> {
			if (!dbColumns.contains(data)) {
				missing.add(data);
			}
		});

		if (missing.isEmpty()) {
			System.out.println("No Missing Columns from " + from);
		} else {
			System.out.println(" Missing Columns from " + from + " are:");
			missing.forEach(data -> System.out.println(data));
		}

	}

}
