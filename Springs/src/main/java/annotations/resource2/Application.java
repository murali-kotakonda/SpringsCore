package annotations.resource2;

//@Resource Example (autowiring by name)


import javax.annotation.Resource;

import org.springframework.stereotype.Component;
 
@Component("application")
public class Application {

	@Resource(name="hdfc")
    private Service service;									
 
    public String toString() {
        return "ApplicationUtil [util=" + service + "]";
    }
    
    public void process(){
    	service.processLoan();
    }
}