package Ex18AutowireByName;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestUser {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext
				("file:src/autowireByName/springs.xml");
		
		AccountService accountService = 
				(AccountService)context.getBean("aService");
		
		accountService.validate();
	}

}
