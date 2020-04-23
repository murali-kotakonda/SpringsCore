package annotations.ex2OLD;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ServiceConfig {
	//autowire=Autowire.BY_NAME , 
	@Bean(initMethod="init",
			destroyMethod="close")
	@Scope(value="prototype")
	public Service service() {
		Dao dao = dao();
		Service service = new Service("testData",dao);
		return service;
	}

	@Bean
	public Dao dao() {
		return new Dao();
	}
}

/*
<beans>
<bean id = "service" class = "Service" />
</beans>  */