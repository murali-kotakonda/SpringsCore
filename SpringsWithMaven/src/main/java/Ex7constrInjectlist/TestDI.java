package Ex7constrInjectlist;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 package: Ex7

Req:List as dependency
UserService has userName (string)  and List<String> as dependency

Springs has to create obj for UserService and set the data for 
userName (string)  and List<String>

 */
public class TestDI {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext
				("file:src/main/java/Ex7constrInjectlist/springs.xml");
		UserService uService =(UserService)	
				context.getBean("uService");
    	System.out.println(uService.getUserName());
    	System.out.println(uService.getConfigs());
	}
}
