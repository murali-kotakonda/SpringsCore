package jdbc.NamedParameterJdbcTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {  

public static void main(String[] args) {  
	ApplicationContext context = 
			new ClassPathXmlApplicationContext
			("file:src/com/spring/jdbc/NamedParameterJdbcTemplate/springs.xml");
	
	  EmployeeDao dao=(EmployeeDao)context.getBean("empDao"); 
	  
	   dao.save(new Employee(21398,"User138",78781));  
}  

}  