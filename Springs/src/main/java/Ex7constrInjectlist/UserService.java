package Ex7constrInjectlist;

import java.util.List;

/**
UserService is a bean class.
UserService has userName and "envs"(list) as dependency.
spring has to create the obj for UserService and set the data for "userName" and "envs"(list).
since we are using constr injection we need to write the constructor in UserService
and write bean tag with two constructor-arg tags in springs.xml
 */
public class UserService { 
	String userName;
	List<String> envs;
	
	public UserService(String userName, List<String> configs) {
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
