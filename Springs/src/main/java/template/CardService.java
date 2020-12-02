package template;

public class CardService {

	private String fileName;

	private String dbName;
	
	private String dbUrl;

	private String filePath;
	
	public void dispatchCard(){
		System.out.println("CardService- dispatchCard");
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


	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}
 

	 

	@Override
	public String toString() {
		return "CardService [fileName=" + fileName + ", filePath=" + filePath
				+ ", getDbName()=" + getDbName() + ", getDbUrl()=" + getDbUrl()
				+ "]";
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public void initProcess(){
		System.out.println("in init");
	}
	
	public void close(){
		System.out.println("close");
	}

	
}
