package template;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext
				("file:src/template/springs.xml");
		
		AccountService accountService = 
				(AccountService)context.getBean("aService");
		CardService cardService =
				(CardService)context.getBean("cService");
		LoanService loanService = (LoanService)context.getBean("lService");

		
		System.out.println(loanService);
		System.out.println(accountService);
		
		
		System.out.println(accountService.getDbName());
		accountService.save();
		
		
		System.out.println(cardService);
				
	}

}
