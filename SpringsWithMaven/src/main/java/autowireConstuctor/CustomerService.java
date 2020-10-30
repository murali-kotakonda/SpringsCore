package autowireConstuctor;

public class CustomerService {

	 private DaoImpl dao;

	public CustomerService(DaoImpl dao) {
		this.dao = dao;
	}
	 
}
