package jdbc;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInsert {
	public static void main(String[] args) {

		// get dao object from springs
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("file:src/main/java/jdbc/springs.xml");
		EmployeeDao dao = (EmployeeDao) context.getBean("empDao");

	    //take input for name, id, sal
		Scanner sc = new Scanner(System.in);

		System.out.println("enter name");
		String name = sc.next();

		System.out.println("enter  id");
		int id = sc.nextInt();

		System.out.println("enter sal");
		long sal = sc.nextLong();

		Employee emp = new Employee(id, name, sal);

		int status = dao.saveEmployee1(emp);
		if (status == 0) {
			System.out.println("insert fail");
		} else {
			System.out.println("insert success");
		}
		System.out.println("rows updated:==" + status);
	}
}
