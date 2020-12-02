package aop.beforeAdvice;

public class UserService {
	
	String userName;
	String pass;

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


	public void process(){
		 System.out.println("processing user ... with userName="+userName+"  , pass="+pass);
	 }

}
