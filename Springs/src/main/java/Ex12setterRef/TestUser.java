package Ex12setterRef;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/com/springs/di/setterRef2/springs.xml");
		UserService uService = (UserService) context.getBean("uService");
		AccountService aService = (AccountService) context.getBean("aService");

		aService.m1();
		uService.m2();
		
	}

}
