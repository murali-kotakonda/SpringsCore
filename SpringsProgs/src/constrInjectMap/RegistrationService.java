package constrInjectMap;

import java.util.Map;
import java.util.Map.Entry;

public class RegistrationService {

	Map<String, String> props;

	public RegistrationService(Map<String, String> props) {
		super();
		this.props = props;
	}


	public void process() {
    	for(Entry<String,String> entry : props.entrySet()) {
    		System.out.println(entry.getKey());
    		System.out.println(entry.getValue());
    	}
	}
	
}
