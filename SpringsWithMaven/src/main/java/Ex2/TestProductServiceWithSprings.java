package Ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProductServiceWithSprings {
	public static void main(String[] args) {
		Product product = new Product();
		product.setId("1234");
		product.setDesc("test desc");
		product.setBrand("lifestyle");
		product.setProductName("shirt merun");
		
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext
				("file:src/Ex2/springs.xml");
	
		ProductService ps = (ProductService)context.getBean("pService");
		ps.save(product);
		
		ProductService ps1 = (ProductService)context.getBean("pService");
		ps1.save(product);
	}
}
