package Ex15lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
  How to specify the init method and destroy method to springs?
  solution:
  1.In springs.xml use destroy-method="<methodname>" along with bean tag.
  2.In springs.xml use init-method="<methodname>"   along with bean tag.
 */
public class TestAccount {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/java/Ex15lifecycle/springs.xml");

		System.out.println("*****loaded springs.xml*******");

		System.out.println("*****GET AccountService OBJ *******");
		AccountService accountService = (AccountService) context.getBean("aService");
		accountService.save();

		System.out.println("*****GET AccountService OBJ*******");
		AccountService accountService1 = (AccountService) context.getBean("aService");
		accountService1.save();

	}
}
