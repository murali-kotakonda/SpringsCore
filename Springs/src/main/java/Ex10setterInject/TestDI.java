package Ex10setterInject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
   Req: 
   AccountService has dbName as dependency. 
   UserService has "userName" and "pass" as dependencies.
   
   Create obj for AccountService and call connect() and save() methods. Create
   obj for UserService and call process() method.
 */

public class TestDI {

	public static void main(String[] args) {
		// get context obj
		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/java/Ex10setterInject/springs.xml");

		// get UserService from springs
		UserService service = (UserService) context.getBean("uService");
		service.process();

		// get AccountService from springs
		AccountService acc = (AccountService) context.getBean("aService");
		acc.connect();
		acc.save();

	}
}
