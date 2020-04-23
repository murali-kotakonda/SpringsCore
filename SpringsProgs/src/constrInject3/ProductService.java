package constrInject3;

public class ProductService {
	
	AccountService accountService;

	public ProductService(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	public AccountService getAccountService() {
		return accountService;
	}
	
	public void saveProduct(){
		System.out.println("save user");
		accountService.save(); 
	}
}
