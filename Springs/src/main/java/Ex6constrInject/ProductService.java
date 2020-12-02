package Ex6constrInject;

/**
ProductService is a bean class.
ProductService  has  "accountService" obj as dependency.
spring has to create the obj for ProductService and set the data for "accountService" obj.
since we are using constr injection we need to write the constructor in ProductService
and write bean tag with one constructor-arg tags in springs.xml
 */
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
