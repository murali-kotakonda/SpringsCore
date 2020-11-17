package annotations.autowire;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 How to specify the scopes using annotations
@Scope(value = "singleton")
@Scope(value = "prototype")
 */

@Component(value = "service1")
public class Service3 {
 
    public void save(){
    	System.out.println("applicationUtil save : ");
    }
    
}

