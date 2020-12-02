package Ex12setterRef;

public class UserService {
	String data;

	DAO dao;

	public void m2(){
		dao.save();
	}

	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}

}
