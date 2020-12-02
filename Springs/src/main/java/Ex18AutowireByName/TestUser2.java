package Ex18AutowireByName;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestUser2 {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext
				("file:src/autowireByName/springs.xml");
		
		UserService uService = (UserService)context.getBean("uService");
		uService.process();
	}

}
