package jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  
public class Test {  

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/com/spring/jdbc/springs.xml");
		EmployeeDao dao = (EmployeeDao) context.getBean("empDao");
		System.out.println(dao);
		
		for(int i=1;i<=10;i++){
			Employee emp = new Employee(325+i, "test326"+i,325326+i);
			int status = dao.saveEmployee1(emp);
			System.out.println("rows updatd:=="+status);
		}
		 
		//UPDATE
		//int status = dao.updateEmployee(emp);
		//System.out.println("rows updatd:=="+status); 
		
		 //delete 
		//int status = dao.deleteEmployeeById(325);
		//System.out.println("rows deleted:=="+status); 
		
		//read
		/*List<Employee> allEmployeesUsingRowMapper = dao.getAllEmployeesUsingRowMapper();
		 
		System.out.println(allEmployeesUsingRowMapper);
		*/

	}  

}  