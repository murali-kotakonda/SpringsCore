package Ex20AutowireConstuctor;

public class LoanService {

	private DaoImpl dao;
	
	private CustomerService cs;

	public LoanService(DaoImpl dao) {
		super();
		this.dao = dao;
	}

	public DaoImpl getDao() {
		return dao;
	}

	public void setDao(DaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public String toString() {
		return "UserService [dao=" + dao + "]";
	}

	public void giveLoan() {
		System.out.println("give loan loan service");
		System.out.println("customer service = "+ cs);
		dao.save();
	}

}
