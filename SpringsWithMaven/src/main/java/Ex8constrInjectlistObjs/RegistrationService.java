package Ex8constrInjectlistObjs;

import java.util.List;

public class RegistrationService {

	String userName;

	List<Config> data;

	
	public RegistrationService(String userName, List<Config> data) {
		super();
		this.userName = userName;
		this.data = data;
	}

	public void process() {
		System.out.println(userName);
		for(Config c: data) {
			System.out.println(c);
		}
	}
	
}
