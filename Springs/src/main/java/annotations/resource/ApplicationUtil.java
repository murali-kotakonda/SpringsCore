package annotations.resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "myAppUtil")
@Scope(value = "singleton")
public class ApplicationUtil {
 
    public void save(){
    	System.out.println("applicationUtil save : ");
    }
    
}