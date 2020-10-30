package jdbc.SimpleJdbcTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {  

public static void main(String[] args) {  
	ApplicationContext context = 
			new ClassPathXmlApplicationContext
			("file:src/com/spring/jdbc/SimpleJdbcTemplate/springs.xml");
	
	  EmployeeDao dao=(EmployeeDao)context.getBean("empDao"); 
	  
	  int status= dao.update(new Employee(21397,"User137",78781));  
	  System.out.println(status); 
}  

}  