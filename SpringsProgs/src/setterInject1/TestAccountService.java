package setterInject1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAccountService {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext
				("file:src/setterInject1/springs.xml");
		 
		AccountService acc = (AccountService)
				context.getBean("aService");
		acc.connect();
		acc.save(); 
	}

}
