package jdbc.ResultSetExtractor;

import java.util.List;

import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  
public class Test {  

public static void main(String[] args) {  
	ApplicationContext context = 
			new ClassPathXmlApplicationContext
			("file:src/com/spring/jdbc/ResultSetExtractor/springs.xml");
	
  EmployeeDao dao=(EmployeeDao)context.getBean("empDao"); 
  
 
  List<Employee> allEmployees  = dao.getAllEmployees();
  
    for(Employee employee : allEmployees){
    	System.out.println(employee);
    }
    
}  

}  