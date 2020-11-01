package Ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
package: Ex2

Need:
1.Product.java   -> Pojo class
2.ProductService.java  -> Service/Bean class
3.TestProductServiceWithoutSprings.java
4.TestProductServiceWithSprings.java
5.springs.xml


Spring create and manage obj for ProductService  [ Bean]
Dev create and manage obj for Product [POJO]

Req:
	Dev has to register ProductService.java in springs.xml
	spring has to create oj for ProductService
  	Dev has to create obj for Product
	Dev has to get the ProductService obj form springs
	dev has to call the save() method on ProductService


 */
public class TestProductServiceWithSprings {
	public static void main(String[] args) {
		Product product = new Product();
		product.setId("1234");
		product.setDesc("test desc");
		product.setBrand("lifestyle");
		product.setProductName("shirt merun");
		
		
		// spring will create obj , dev has to get obj from springs

		// get context obj
		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/java/Ex2/springs.xml");

		// get ProductService from springs
		ProductService ps = (ProductService) context.getBean("pService");
		ps.save(product);
		
		ProductService ps1 = (ProductService)context.getBean("pService");
		ps1.save(product);
	}
}
