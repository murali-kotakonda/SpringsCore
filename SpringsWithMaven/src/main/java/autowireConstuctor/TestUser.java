package autowireConstuctor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext
				("file:src/autowireConstuctor/springs.xml");
		
		AccountService accountService = (AccountService)context.getBean("aService");
		System.out.println(accountService);
		accountService.process();
	}

}
