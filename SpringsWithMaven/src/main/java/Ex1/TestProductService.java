package Ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
package: Ex1

Need:
1.ProductService.java
2.springs.xml
3.TestProductService.java
4.UserService.java
5.TestProductAndUserService

Earlier:
-------------------
ProductService p = new ProductService();
p.getAllProducts();

Now
-----------------------
Req:
	Dev has to register ProductService.java in springs.xml
	spring has to create oj for ProductService
	Dev has to get the obj form springs
	dev has to call the getAllProducts()

 */
public class TestProductService {

	public static void main(String[] args) {
		
		//get context obj
		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/java/Ex1/springs.xml");
		
		//2 using context obj get the prodcuservice obj
		ProductService ps = (ProductService)context.getBean("pService");
		ps.getAllProducts();
		
		ProductService ps1 = (ProductService)context.getBean("pService");
		ps1.getAllProducts();
	    // only one obj is returned even though getBean("pService") is called two times

		if (ps == ps1) {
			System.out.println("same obj ");
		} else {
			System.out.println("diff same");
		}
	}
}

