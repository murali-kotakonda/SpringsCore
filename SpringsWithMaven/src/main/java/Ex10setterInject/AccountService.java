package Ex10setterInject;
/**
AccountService is a bean class.
AccountService has dbName as dependency.
spring has to create the obj for AccountService and set the data for dbName.
since we are using setter injection we need to write the setter methods for every property in AccountService
and write bean tag for AccountService with one <property> tag.
 */
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
