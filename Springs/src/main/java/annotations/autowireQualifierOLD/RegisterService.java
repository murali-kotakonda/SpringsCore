package annotations.autowireQualifierOLD;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
 
@Component("registerService")
public class RegisterService {
 
	@Autowired
	@Qualifier("loginDAO")
	private DAO dao;
	
	@Autowired
	@Qualifier("registerDAO")
	private DAO dao1;
	 
	@Override
	public String toString() {
		return "RegisterDAO [dao=" + dao + "]";
	}
	
	
	public void process(){
		dao.save();
		dao1.save();
	}
	
}