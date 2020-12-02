package Ex19AautowireByType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext
				("file:src/autowireByType/springs.xml");
		UserService uService = 
				(UserService) context.getBean("uService");
		uService.process();
		
		
		CustomerService cService = (CustomerService) 
				context.getBean("cService");
		LoanService lService = (LoanService)
				context.getBean("lService");
		lService.provideLoan();
		System.out.println(uService);
		System.out.println(cService);
	}

}
