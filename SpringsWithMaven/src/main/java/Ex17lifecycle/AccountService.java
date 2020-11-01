package Ex17lifecycle;

import org.springframework.beans.factory.InitializingBean;

public class AccountService implements InitializingBean {

	private String dbName;

	private String dbName1;

	public String getDbName1() {
		return dbName1;
	}
	public void setDbName1(String dbName1) {
		System.out.println(" setDbName1 ");
		this.dbName1 = dbName1;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		System.out.println(" setDbName ");
		this.dbName = dbName;
	}

	public AccountService() {
		System.out.println("ac obj creted");
	}
	public void save() {
		System.out.println("account- save");
	}
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet::hello");
	}
}
