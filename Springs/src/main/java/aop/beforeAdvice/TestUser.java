package aop.beforeAdvice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext
				("file:src/com/springs/aop/beforeAdvice/springs.xml");
		UserService service = (UserService)
				context.getBean("uService");
		
		service.process();
		
	}

}
