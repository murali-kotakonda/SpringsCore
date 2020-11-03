package Ex10setterInject;
/**
UserService is a bean class.
UserService has userName and pass  as dependency.
spring has to create the obj for UserService and set the data for userName and pass.
since we are using setter injection we need to write the setter methods for every property in UserService
and write bean tag for UserService with two <property> tag.
 */
public class UserService {

	private String userName;
	private String pass;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public void process() {
		System.out.println(
			"processing user ... with userName=" + userName
				+ "  , pass=" + pass);
	}

}
