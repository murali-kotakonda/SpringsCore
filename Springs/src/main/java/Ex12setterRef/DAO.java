package Ex12setterRef;

public class DAO {

	String userName;

	String password;
	
	public void save(){
		System.out.println("saving data using "+userName);
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
