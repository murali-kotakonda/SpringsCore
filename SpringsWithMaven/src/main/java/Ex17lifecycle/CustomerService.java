package Ex17lifecycle;

public class CustomerService {

	public CustomerService(){
		System.out.println("CustomerService constr");
	}
	public void save(){
		//saving to db
		System.out.println("saving Customer::");
	}
}
