package setterRef;

public class AccountService {

	private String dbName;
	
	public void save() {
		System.out.println("inside m2");
	}
	
	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	
	
	public void initProcess(){
		System.out.println("in init");
	}
	
	public void close(){
		System.out.println("close");
	}


}
