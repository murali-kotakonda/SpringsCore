package Ex10setterInject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext
				("file:src/setterInject1/springs.xml");
		
		UserService service = (UserService)
				context.getBean("uService");
		
		service.process();
		
	}

}
