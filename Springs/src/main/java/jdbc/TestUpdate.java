package jdbc;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUpdate {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	System.out.println("enter name");
	String name=sc.next();
	
	System.out.println("enter  id");
	int id = sc.nextInt();
	
	System.out.println("enter sal");
	long sal= sc.nextLong();
	
	Employee  emp = new Employee(id, name, sal);

	ApplicationContext context = new ClassPathXmlApplicationContext(
			"file:src/main/java/jdbc/springs.xml");
	EmployeeDao dao = (EmployeeDao) context.getBean("empDao");
	
	int status = dao.updateEmployee(emp);
	if(status==0){
		System.out.println("update fail");
	}else{
		System.out.println("update success");
	}
	System.out.println("rows updated:=="+status);
}
}
