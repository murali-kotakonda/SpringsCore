package setterRef;

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
