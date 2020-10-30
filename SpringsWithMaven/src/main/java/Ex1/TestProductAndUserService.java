package Ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProductAndUserService {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/Ex1/springs.xml");
		
		//2
		ProductService ps = (ProductService)context.getBean("pService");
		ps.getAllProducts();
		
		
		UserService us = (UserService)context.getBean("userServiceObj");
		us.process();
		
		}
}

