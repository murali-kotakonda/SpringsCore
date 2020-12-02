package annotations.autowireQualifierOLD;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
 
 
public class TestRegister {
 
    public static void main(String args[]) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
        		ApplicationConfig.class);
 
        RegisterService registerService = (RegisterService) context.getBean("registerService");
        System.out.println("registerService Details : " + registerService);
        
        registerService.process();
    }
 
}