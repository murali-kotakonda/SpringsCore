package constrInject3;

public class AccountService {

	private String dbName;

	public AccountService(String dbName) {
		super();
		this.dbName = dbName;
	}
	
	
	public String getDbName() {
		return dbName;
	}

	public void save(){
		System.out.println("account- save");
	}
}
