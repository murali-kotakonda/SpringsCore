package setterInject1;

public class AccountService {

	private String dbName;

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	
	public void connect(){
		System.out.println("connecting db with user:"+dbName);
	}
	
	public void save(){
		System.out.println("account- save using"+dbName);
	}
}
