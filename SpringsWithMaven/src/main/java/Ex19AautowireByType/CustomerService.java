package Ex19AautowireByType;

public class CustomerService {

	private DaoImpl dao1;

	public DaoImpl getDao1() {
		return dao1;
	}

	public void setDao1(DaoImpl dao1) {
		this.dao1 = dao1;
	}

	public void getCustomer() {
		System.out.println("in get customer");
	}

}
