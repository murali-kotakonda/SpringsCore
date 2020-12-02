package Ex18AutowireByName;

public class AccountService {
 
	private DaoImpl dao;
	private UserService uService;
 	public UserService getuService() {
		return uService;
	}
	public void setuService(UserService uService) {
		this.uService = uService;
	}
	public void setDao(DaoImpl dao) {
		this.dao = dao;
	}
	
	public void validate() {
		uService.process();
		dao.save();
	}
	
}
