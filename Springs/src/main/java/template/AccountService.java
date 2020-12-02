package template;

public class AccountService  {

	private String dbName;
	
	private String dbUrl;
	
	private String accountType;

	public void save(){
		System.out.println("account- save");
	}
	
	
	public String getAccountType() {
		return accountType;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}




	@Override
	public String toString() {
		return "AccountService [accountType=" + accountType + ", getDbName()="
				+ getDbName() + ", getDbUrl()=" + getDbUrl() + "]";
	}



	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void initProcess(){
		System.out.println("in init");
	}
	
	public void close(){
		System.out.println("close");
	}

	
}
