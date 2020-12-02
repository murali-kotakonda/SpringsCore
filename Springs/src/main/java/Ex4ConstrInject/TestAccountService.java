package Ex4ConstrInject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAccountService {

	public static void main(String[] args) {
		// get context obj
		ApplicationContext context = 
				new ClassPathXmlApplicationContext
				("file:src/main/java/Ex4constrInject/springs.xml");
		 
		// get AccountService from springs
		AccountService acc = (AccountService)
				context.getBean("aService");
		acc.connect();
		acc.save(); 
	}

}
