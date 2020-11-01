package Ex17lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProduct {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/lifecycle3/springs.xml");
		System.out.println("***********springs.xml loaded*****************");
		
		System.out.println("****************get aService ****************************");
		AccountService accountService = (AccountService) context.getBean("aService");
		
		System.out.println("****************get pService ****************************");
		ProductService pService = (ProductService) context.getBean("pService");

		accountService.save();
		System.out.println(accountService.getDbName());
		pService.save();
		System.out.println("end");
	}

}
