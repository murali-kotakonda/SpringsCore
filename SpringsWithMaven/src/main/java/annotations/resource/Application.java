package annotations.resource;


import javax.annotation.Resource;

import org.springframework.stereotype.Component;
 
@Component("myApp")
public class Application {

	@Resource(name="myAppUtil")
    private ApplicationUtil util;									
 
    public void process(){
    	System.out.println("Application::in process  method");
    	util.save();
    }
}