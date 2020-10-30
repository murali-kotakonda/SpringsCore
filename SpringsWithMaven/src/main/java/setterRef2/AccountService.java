package setterRef2;

public class AccountService {
	DAO dao;
	String value;

	public void m1(){
		dao.save();
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	
}
