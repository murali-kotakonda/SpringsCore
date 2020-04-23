package lifecycle2;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class AccountService implements InitializingBean, DisposableBean {

	private String dbName;

	public String getDbName() {
		return dbName;
	}

	/**
	 * setter method called by springs
	 * 
	 * @param dbName
	 */
	public void setDbName(String dbName) {
		System.out.println("inject db name");
		this.dbName = dbName;
	}

	/**
	 * constr. called by springs
	 */
	public AccountService() {
		System.out.println("ac obj created");
	}

	/**
	 * service method called by developer
	 */
	public void save() {
		System.out.println("account- save");
	}

	/**
	 * init method ; no need to mention in springs.xml called by springs
	 */
	public void destroy() throws Exception {
		System.out.println("destroy impl ....");
	}

	/**
	 * destroy method ; no need to mention in springs.xml called by springs
	 */
	public void afterPropertiesSet() throws Exception {
		System.out.println("initializing props....");
	}

}
