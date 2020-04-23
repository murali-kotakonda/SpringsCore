package constrInjectMap;

import java.util.HashMap;
import java.util.Map;

public class RegistrationSingleton { 
	
	private String dbName;
	private String pass;
	
	private static RegistrationSingleton instance;
	
	private RegistrationSingleton(){
		
	}
	
	private RegistrationSingleton(String dbName, String pass) {
		super();
		this.dbName = dbName;
		this.pass = pass;
	}
	
	public static RegistrationSingleton getObject(){
		if(instance==null)
		{
			instance = new RegistrationSingleton("system","oracle");
		}
		return instance;
	}
	
	
}
