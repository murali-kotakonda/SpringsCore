package Ex13setterRefIntf;

public class RegistrationService {

	Dao dao;
	
	String config;
	
	public void setConfig(String config) {
		this.config = config;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	
	public Dao getDao() {
		return dao;
	}

	public String getConfig() {
		return config;
	}

	
	public void register() {
		System.out.println(this);
		dao.process();
	}

	@Override
	public String toString() {
		return "RegistrationService [dao=" + dao + ", config=" + config + "]";
	}
	
	
	
	public RegistrationService(Dao dao) {
		super();
		this.dao = dao;
	}

	public RegistrationService() {
		super();
	}

}
