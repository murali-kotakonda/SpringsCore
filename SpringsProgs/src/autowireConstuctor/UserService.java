package autowireConstuctor;

public class UserService {

	private DaoImpl dao1;
	
	private CustomerService cs;

	public UserService(DaoImpl dao1, CustomerService cs) {
		super();
		this.dao1 = dao1;
		this.cs = cs;
	}
	 
	 	
}
