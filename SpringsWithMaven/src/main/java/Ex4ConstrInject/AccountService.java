package Ex4ConstrInject;

public class AccountService {

	private String dbName;


	 public AccountService(String dbName) {
		super();
		this.dbName = dbName;
	}


	public void connect(){
		System.out.println("connecting db with user:"+dbName);
	}
	 
	
	
	public void save(){
		System.out.println("account- save using"+dbName);
	}
}
