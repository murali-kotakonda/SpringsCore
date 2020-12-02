package Ex11setterRef;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
Req:
AccountService has dbName as dependency
UserService has "userName" and "accountService" obj as dependency.

AccountService.java:
--------------------------
- has save() method

UserService.java:
---------------------
- has saveUser() method 
- saveUser() internally calls the save() method of AccountService.

Create obj for UserService and call the saveUser() method.

 */
public class TestDI {

	public static void main(String[] args) {
		 //get  context obj
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/main/java/Ex11SetterRef/springs.xml");
		
		 //get UserService obj from springs
		UserService service = (UserService) context.getBean("uService");
		service.saveUser();
	}
}
