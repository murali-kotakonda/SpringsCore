package Ex7constrInjectlist;

import java.util.List;

public class UserService { 
	String userName;
	List<String> envs;
	
	public UserService(String userName, 
			List<String> configs) {
		super();
		this.userName = userName;
		this.envs = configs;
	}

	public String getUserName() {
		return userName;
	}

	public List<String> getConfigs() {
		return envs;
	}
}
