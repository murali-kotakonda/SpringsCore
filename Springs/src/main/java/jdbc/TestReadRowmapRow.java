package jdbc;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestReadRowmapRow {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/java/jdbc/springs.xml");
		EmployeeDao dao = (EmployeeDao) context.getBean("empDao");

		System.out.println("enter id");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		Employee emp = dao.getEmpById(id);
		if (emp == null) {
			System.out.println("emp not found");
		} else {
			System.out.println(emp);
		}

		System.out.println("************print all emps**********");
		List<Employee> allEmps = dao.getAllEmployees2();
		// Employee emp = dao.getEmpById(329);
		for (Employee e : allEmps) {
			System.out.println(e);
		}
	}
}