package annotations.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 @Autowired can be used
- before field
- before constructr
- before setter method.
 */
@Service
public class RegisterService {

	@Autowired // auto wire by type
	private RegisterDAO dao;

	//@Autowired // autoiwire by constrtr
	public RegisterService(RegisterDAO dao) {
		super();
		this.dao = dao;
	}
	
	//@Autowired // on Setter method
	public void setDao(RegisterDAO dao) {
		this.dao = dao;
	}

	public RegisterDAO getDao() {
		return dao;
	}
	
	public RegisterService(){
		
	}
			
	public void process() {
		dao.save();
	}

	@Override
	public String toString() {
		return "RegisterDAO [dao=" + dao + "]";
	}

}