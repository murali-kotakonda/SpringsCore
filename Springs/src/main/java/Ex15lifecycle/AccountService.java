package Ex15lifecycle;

public class AccountService {

	private String dbName;

	public String getDbName() {
		return dbName;
	}

	/**
	 * setter method
	 * called by springs
	 * @param dbName
	 */
	public void setDbName(String dbName) {
		System.out.println("inject db name");
		this.dbName = dbName;
	}

	/**
	 * constr.
	 * called by springs
	 */
	public AccountService() {
		System.out.println("ac obj created");
	}

	/**
	 * service method
	 * called by developer
	 */
	public void save() {
		System.out.println("account- save");
	}

	/**
	 * init method ; mention in springs.xml using 	init-method=  along with bean tag.
	 * called by springs
	 */
	public void myInit() {
		System.out.println("in init");
	}

	/**
	 * destroy method ; mention in springs.xml using destroy-method= along with bean tag.
	 * called by springs
	 */
	public void myClose() {
		System.out.println("close");
	}
}
