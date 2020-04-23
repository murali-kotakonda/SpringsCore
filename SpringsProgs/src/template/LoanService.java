package template;

public class LoanService{

	private String dbName;
	
	private String dbUrl;
	
	private String loanDept;
	
	private String loanbranch;
	
	
	
	public void processLoan(){
		System.out.println("loaninfo");
	}
	
	
	
	
	
	public String getLoanDept() {
		return loanDept;
	}

	public void setLoanDept(String loanDept) {
		this.loanDept = loanDept;
	}

	public String getLoanbranch() {
		return loanbranch;
	}

	public void setLoanbranch(String loanbranch) {
		this.loanbranch = loanbranch;
	}

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
