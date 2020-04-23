package annotations.ex1OLD;

import org.springframework.stereotype.Component;

@Component
public class MyService {
	private String msg;

 	public void process(){
		System.out.println("test -- proceed ");
	}

	public MyService(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}
