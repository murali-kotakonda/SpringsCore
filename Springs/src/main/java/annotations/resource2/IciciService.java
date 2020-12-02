package annotations.resource2;

import org.springframework.stereotype.Component;

@Component("icici")
public class IciciService implements Service {

	public void processLoan() {
		System.out.println("icici obj");
	}

}
