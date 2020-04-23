package jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMultiInsert {
	public static void main(String[] args) {

		// get dao object from springs
		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/jdbc/springs.xml");
		EmployeeDao dao = (EmployeeDao) context.getBean("empDao");

		for (int i = 1000; i < 100; i++) {
			Employee emp = new Employee(i+1, "user"+i, i+5000);
			int status = dao.saveEmployee1(emp);
		}
		
		System.out.println("insert success");
	}
}
