package Ex6constrInject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 package: Ex6

Req:
AccountService has dbName as dependency
UserService has "userName" and "accountService" obj as dependency.
ProductService has AccountService obj as dependency

AccountService
-> we have save() method

ProductService 
-> we have saveProduct() which internally calls save() method from accountService.

UserService 
-> we have saveUser() which internally calls save() method from accountService.

 */
public class TestUserProduct {

	public static void main(String[] args) {
		//create context obj
		ApplicationContext context = 
				new ClassPathXmlApplicationContext
				("file:src/main/java/Ex6constrInject/springs.xml");

		//get UserService obj
		UserService uService = (UserService)context.getBean("uService");
		
		//get ProductService obj
		ProductService pService = (ProductService)context.getBean("pService");
		
		uService.saveUser();
		pService.saveProduct();
	}

}
