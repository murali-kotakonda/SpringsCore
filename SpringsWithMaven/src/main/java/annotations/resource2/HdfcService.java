package annotations.resource2;

import org.springframework.stereotype.Component;

@Component("hdfc")
public class HdfcService implements Service {

	public void processLoan() {
		System.out.println("hdfc obj ");
	}

}
