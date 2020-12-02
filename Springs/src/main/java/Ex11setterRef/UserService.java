package Ex11setterRef;
/**
UserService is a bean class.
UserService has userName and "accountService" obj as dependency.
spring has to create the obj for UserService and set the data for "userName" and "accountService" obj.
since we are using setter injection we need to write the setter methods in UserService
and write bean tag with two <property> tags in springs.xml.
 */
public class UserService {
	
	String userName;

	AccountService accountService;
	
	public void saveUser(){
		accountService.save();
		System.out.println("inside m1");
		
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public String getUserName() {
		return userName;
	}

	public AccountService getAccountService() {
		return accountService;
	}
}
