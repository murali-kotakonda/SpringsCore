package Ex17lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAccount {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/lifecycle3/springs.xml");
		System.out.println("***********springs.xml loaded*****************");
		
		System.out.println("****************get aService ****************************");
		AccountService accountService = (AccountService) context.getBean("aService");
		
		accountService.save();
		System.out.println(accountService.getDbName());
	}

}
