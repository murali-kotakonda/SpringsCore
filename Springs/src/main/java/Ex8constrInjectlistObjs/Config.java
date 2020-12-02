package Ex8constrInjectlistObjs;

public class Config {

	String fileName;
	String path;
	
	public Config(String fileName, String path) {
		super();
		this.fileName = fileName;
		this.path = path;
	}

	public String toString() {
		return "Config [fileName=" + fileName + ", path=" + path + "]";
	}
	 
	
}
