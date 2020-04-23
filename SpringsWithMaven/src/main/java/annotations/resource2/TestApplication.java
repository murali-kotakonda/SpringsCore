package annotations.resource2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class TestApplication {
	public static void main(String args[]) {
		AbstractApplicationContext context = 
				new AnnotationConfigApplicationContext(
				ApplicationConfig.class);

		// Byname Autowiring
		Application application = (Application) context.getBean("application");
		Application application1 = (Application) context.getBean(Application.class);
		System.out.println("Application Details : " + application);
		application.process();

	}
}
