package Ex4ConstrInject;

/**
UserService is a bean class.
UserService has userName and pass as dependency.
spring has to create the obj for UserService and set the data for userName and pass.
since we are using constr injection we need to write the constructor in UserService
and write bean tag for UserService
 */
public class UserService {
	//db info
	String userName;
	String pass;

	public UserService(String userName, String pass) {
		this.userName = userName;
		this.pass = pass;
	}

	public void process(){
		System.out.println("processing user using "+userName + " and " + pass );
	}
	
}
