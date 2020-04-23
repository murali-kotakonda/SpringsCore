package annotations.resource;


import javax.annotation.Resource;

import org.springframework.stereotype.Component;
 
@Component("myApp")
public class Application {

	@Resource(name="myAppUtil")
    private ApplicationUtil util;									
 
    public void process(){
    	System.out.println("in process");
    	util.save();
    }
    public String toString() {
        return "ApplicationUtil [util=" + util + "]";
    }
}