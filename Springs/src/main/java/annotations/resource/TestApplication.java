package annotations.resource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 /**
 Ex:
----------

Req:
Application has ApplicationUtil as dependency:
Resolve dependency using spring annotations @Resource

solution:
1.create configuration class @Configuration + @ComponentScan and specify the package name
2.create Application and use @Service annotation
3.create ApplicationUtil and use  @Component annotation
and for resolving dependency use  @Resource annotation with bean name
4.crate main class and get the bean objs.

*/
public class TestApplication {
	public static void main(String args[]) {
		//get context obj
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		//approach1 get bean obj for Application 
		Application application = (Application) context.getBean("myApp");
		
		//approach2 get bean obj for Application
		Application application1 = (Application) context.getBean(Application.class);
		
		application.process();
	}
}
