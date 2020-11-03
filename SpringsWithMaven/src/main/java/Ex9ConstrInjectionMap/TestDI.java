package Ex9ConstrInjectionMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
package: Ex8

Req:Map as dependency
RegistrationService has userName (string)  and Map<String, String> props as dependency

Springs has to create obj for RegistrationService and set the data for 
userName (string)  and Map<String, String>
 */
public class TestDI {
	
	public static void main(String[] args) {
		//get context obj
		ApplicationContext context =new ClassPathXmlApplicationContext("file:src/main/java/Ex9constrInjectMap/springs.xml");
		
		//get the  RegistrationService obj
		RegistrationService service = (RegistrationService) context.getBean("registerService");
		service.process();
	}
}