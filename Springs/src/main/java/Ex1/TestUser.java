package Ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

	public static void main(String[] args) {
		//get the context object
		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/java/Ex1/springs.xml");

		UserService uServiceObj = (UserService) context.getBean("userServiceObj");
		uServiceObj.process();

		ProductService pservice = (ProductService) context.getBean("pService");
		pservice.getAllProducts();
	}
}
