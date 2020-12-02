package Ex14scopes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
Req:
	for RegistrationService provide scope as singleton
	for UserService provide scope as prototype
	exhibit the behaviour of getBean() method
 */
public class TestDI {
	public static void main(String[] args) {
		//get context object
		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/java/Ex14scopes/springs.xml");

		//get the multiple RegistrationService objs using getBean() method
		RegistrationService rService1 = (RegistrationService) context.getBean("rService");
		RegistrationService rService2 = (RegistrationService) context.getBean("rService");
		RegistrationService rService3 = (RegistrationService) context.getBean("rService");
		RegistrationService rService4 = (RegistrationService) context.getBean("rService");

		System.out.println("*******rService singleton *********");
		System.out.println(rService1);
		System.out.println(rService2);
		System.out.println(rService3);
		System.out.println(rService4);

		//get the multiple UserService objs using getBean() method
		UserService uService1 = (UserService) context.getBean("uService");
		UserService uService2 = (UserService) context.getBean("uService");
		UserService uService3 = (UserService) context.getBean("uService");
		UserService uService4 = (UserService) context.getBean("uService");

		System.out.println("*******uService prototype *********");
		System.out.println(uService1);
		System.out.println(uService2);
		System.out.println(uService3);
		System.out.println(uService4);
	}

}
