package Ex6constrInject;


/**
UserService is a bean class.
UserService has userName and "accountService" obj as dependency.
spring has to create the obj for UserService and set the data for "userName" and "accountService" obj.
since we are using constr injection we need to write the constructor in UserService
and write bean tag with two constructor-arg tags in springs.xml
 */
public class UserService {
	
	String userName;

	AccountService accountService;

	public UserService(String userName, AccountService accountService) {
		this.userName = userName;
		this.accountService = accountService;
	}


	public void saveUser(){
		System.out.println("save user");
		accountService.save(); 
	}
	
	
	
	public String getUserName() {
		return userName;
	}

	public AccountService getAccountService() {
		return accountService;
	}
	
	
}
