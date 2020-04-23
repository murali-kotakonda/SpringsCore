package annotations.resource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class TestApplication {
	public static void main(String args[]) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		//approach1
		Application application = (Application) context.getBean("myApp");
		//approach2
		Application application1 = (Application) context.getBean(Application.class);
		
		application.process();
	}
}
