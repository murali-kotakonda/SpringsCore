package Ex17lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProductCustomer {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/java/Ex17lifecycle/springs.xml");
		System.out.println("***********springs.xml loaded*****************");
		
		System.out.println("****************get ProductService ****************************");
		ProductService pService = (ProductService) context.getBean("pService");
		pService.save();
		
		System.out.println("****************get CustomerService ****************************");
		CustomerService cService = (CustomerService) context.getBean("cService");
		cService.save();
	}

}
