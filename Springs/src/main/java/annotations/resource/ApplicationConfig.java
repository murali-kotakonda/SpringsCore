package annotations.resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"annotations.resource","service"})
public class ApplicationConfig {
 
}