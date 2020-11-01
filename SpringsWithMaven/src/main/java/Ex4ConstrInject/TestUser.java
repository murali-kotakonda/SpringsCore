package Ex4ConstrInject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext
				("file:src/constrInject1/springs.xml");
		UserService service = (UserService) context.getBean("uService");

		service.process();
		
 	}

}
