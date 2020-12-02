package annotations.autowire;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 Ex:
----------

Req:
RegisterService has RegisterDAO as dependency:
Resolve dependency using spring annotations

solution:
1.create configuration class @Configuration + @ComponentScan and specify the package name
2.create RegisterDAO and use @Repository annotation
3.create RegisterService and use @Service annotation
and for resolving dependency use  @Autowired annotation.
4.crate main class and get the bean objs.

*/
public class TestRegister {

	public static void main(String args[]) {
		//get the context object
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		//using context obj get the bean objs
		RegisterService registerService = (RegisterService) context.getBean(RegisterService.class);

		registerService.process();
		
		RegisterDAO registerDAO = (RegisterDAO) context.getBean(RegisterDAO.class);
		registerDAO.save();
	}

}