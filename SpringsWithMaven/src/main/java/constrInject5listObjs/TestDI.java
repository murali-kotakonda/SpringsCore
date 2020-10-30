package constrInject5listObjs;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDI {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/com/springs/di/listObjs/springs.xml");

		RegistrationService service = (RegistrationService) context.getBean("registerService");

		
		service.process();
	}

}
