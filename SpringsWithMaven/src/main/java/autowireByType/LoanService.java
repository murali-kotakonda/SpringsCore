package autowireByType;

public class LoanService {

	private DaoImpl dao;
	
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

	public void provideLoan() {
		System.out.println("give loan loan service");
		dao.save();
	}
}
