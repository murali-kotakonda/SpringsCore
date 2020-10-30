package template;

public class Service {

	private String dbName;
	
	private String dbUrl;

	public String getDbName() {
		return dbName;
	}

	@Override
	public String toString() {
		return "Service [dbName=" + dbName + ", dbUrl=" + dbUrl + "]";
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

}
