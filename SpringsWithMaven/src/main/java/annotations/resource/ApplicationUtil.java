package annotations.resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "myAppUtil")
@Scope(value = "singleton")
public class ApplicationUtil {
 
    private String name = "admin";
 
    public void save(){
    	System.out.println("applicationUtil save using: "+name);
    }
    
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    
    @Override
    public String toString() {
        return "ApplicationUser [name=" + name + "]";
    }
}