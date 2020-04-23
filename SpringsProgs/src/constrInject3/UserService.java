package constrInject3;

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
