package Ex14scopes;

public class UserService {
	String userName;
	String pass;
	
	public UserService(String userName, String pass) {
		super();
		this.userName = userName;
		this.pass = pass;
	}

	 public void process( ){
		 System.out.println("processing user ... with userName="+userName+"  , pass="+pass);
	 }

}
