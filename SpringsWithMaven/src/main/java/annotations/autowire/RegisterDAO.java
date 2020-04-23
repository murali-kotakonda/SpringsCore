package annotations.autowire;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterDAO {

	private String dbName = "oracle";

	public void save() {
		System.out.println("saved");
	}
	
	public String toString() {
		return "RegisterDAO [dbName=" + dbName + "]";
	}
	
}