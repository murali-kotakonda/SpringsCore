package Ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
Req:
spring has to create obj for both UserService and ProductService

	Dev has to register ProductService.java and UserService.java in springs.xml
	spring has to create obj for ProductService + UserService
	Dev has to get the objs form springs using beanIds
	dev has to call the getAllProducts() on ProductService
	dev has to call the process() on UserService
 */
public class TestProductAndUserService {

	public static void main(String[] args) {
		//1. get context obj
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/main/java/Ex1/springs.xml");
		
		//2. Get ProductService obj
		ProductService ps = (ProductService)context.getBean("pService");
		ps.getAllProducts();
		
		//3. Get UserService obj
		UserService us = (UserService)context.getBean("userServiceObj");
		us.process();
		
		}
}

