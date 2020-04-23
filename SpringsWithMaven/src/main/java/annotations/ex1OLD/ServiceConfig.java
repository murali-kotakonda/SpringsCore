package annotations.ex1OLD;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
	
	@Bean
	public MyService service() {
		return new MyService("testDataXX");
	}
}

/*
<beans>
<bean id = "service" 
class = "annotations.ex1.Service" />
</beans>  */