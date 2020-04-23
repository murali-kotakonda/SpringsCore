package jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestReadRowmapper {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/com/spring/jdbc/springs.xml");
		EmployeeDao dao = (EmployeeDao) context.getBean("empDao");
		List<Employee> allEmps = dao.getAllEmployeesUsingRowMapper();
		for (Employee e : allEmps) {
			System.out.println(e);
		}
	}
}
