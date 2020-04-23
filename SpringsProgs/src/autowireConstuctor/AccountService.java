package autowireConstuctor;

public class AccountService {

	private DaoImpl myDao1;
	private CustomerService cService;
	private UserService uService;
	
	//private LoanService ls;

	public AccountService(DaoImpl myDao1) {
		super();
		this.myDao1 = myDao1;
	}


	public AccountService(DaoImpl myDao1, CustomerService cService, UserService uService) {
		super();
		this.myDao1 = myDao1;
		this.cService = cService;
		this.uService = uService;
	}


	public AccountService(DaoImpl myDao1, CustomerService cService) {
		super();
		this.myDao1 = myDao1;
		this.cService = cService;
	}


	@Override
	public String toString() {
		return "AccountService [myDao1=" + myDao1 + ", cService=" + cService + ", uService=" + uService + "]";
	}


	public void process() {
		myDao1.save();
		System.out.println("myDao1 ="+myDao1 );
		System.out.println("cService ="+cService );
		System.out.println("uService ="+uService );
		//System.out.println("ls ="+ls );
	}
	//same no of args

}
