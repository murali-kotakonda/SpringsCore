package autowireByType;

public class AccountService {

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
	
	public void Process() {
		dao.save();
	}

}
