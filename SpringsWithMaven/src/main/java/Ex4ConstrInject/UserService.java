package Ex4ConstrInject;

public class UserService {
	//db info
	String userName;
	String pass;

	public UserService(String userName, String pass) {
		this.userName = userName;
		this.pass = pass;
	}

	public void process(){
		System.out.println("processing user using "+userName);
	}
	
}
