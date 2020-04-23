package setterRefIntf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDI {
	
	public static void main(String[] args) {
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext
				("file:src/main/java/setterRef3/springs.xml");
		
		RegistrationService service = 
				(RegistrationService)context.getBean("registerService");
    	service.register();
    	 
    	
	}

}
