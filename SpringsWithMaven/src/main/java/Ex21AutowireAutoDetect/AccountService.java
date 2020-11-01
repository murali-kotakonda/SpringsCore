package Ex21AutowireAutoDetect;

public class AccountService {

	 private DaoImpl dao;

	public AccountService(DaoImpl dao) {
		super();
		this.dao = dao;
	}

	@Override
	public String toString() {
		return "AccountService [dao=" + dao + "]";
	}

	public DaoImpl getDao() {
		return dao;
	}

	public void setDao(DaoImpl dao) {
		this.dao = dao;
	}


	 
	 
	 
}
