package Ex1;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/Ex1/springs.xml");

		UserService uServiceObj = (UserService) context.getBean("userServiceObj");
		uServiceObj.process();

		ProductService pservice = (ProductService) context.getBean("pService");
		pservice.getAllProducts();
	}
}
