package jdbc;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDelete {
	public static void main(String[] args) {
		deletByName();
		//deletById();
	}

	private static void deletByName() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/jdbc/springs.xml");
		EmployeeDao dao = (EmployeeDao) context.getBean("empDao");
		// int status = dao.saveEmployee(emp);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter name to delete");
		String userName=sc.next();
		int status = dao.deleteEmployeeByName(userName);
		if (status == 0) {
			System.out.println("delete fail");
		} else {
			System.out.println("delete success");
		}
		System.out.println("rows delete:==" + status);
	}
	
	private static void deletById() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/com/spring/jdbc/springs.xml");
		EmployeeDao dao = (EmployeeDao) context.getBean("empDao");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter  id to delete");
		int id = sc.nextInt();
		
		int status = dao.deleteEmployeeById(id);
		if (status == 0) {
			System.out.println("delete fail");
		} else {
			System.out.println("delete success");
		}
		System.out.println("rows delete:==" + status);
	}
}
