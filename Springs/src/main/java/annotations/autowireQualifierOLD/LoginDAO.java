package annotations.autowireQualifierOLD;

import org.springframework.stereotype.Component;

@Component("loginDAO")
public class LoginDAO implements DAO {

	public void save() {
		System.out.println("LoginDAO - process");
	}
}