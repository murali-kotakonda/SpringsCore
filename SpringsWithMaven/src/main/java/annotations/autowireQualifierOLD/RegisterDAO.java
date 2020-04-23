package annotations.autowireQualifierOLD;

import org.springframework.stereotype.Component;

@Component("registerDAO")
public class RegisterDAO implements DAO {

	public void save() {
		System.out.println("RegisterDAO");
	}
}