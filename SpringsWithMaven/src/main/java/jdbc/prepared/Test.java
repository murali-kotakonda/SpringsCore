package jdbc.prepared;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Test {  

public static void main(String[] args) {  
	ApplicationContext context = 
			new ClassPathXmlApplicationContext
			("file:src/com/spring/jdbc/prepared/springs.xml");
	
  EmployeeDao dao=(EmployeeDao)context.getBean("empDao"); 
  
  boolean status= dao.saveEmployee(new Employee(21396,"User136",78781));  
  System.out.println(status);   
}  

}  