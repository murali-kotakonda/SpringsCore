package issue;

public class ProductService {

	ProductHelper helper;
	
	public void validate(){
		System.out.println("entering ProductService.validate method");
		helper.check();
		System.out.println("exit ProductService.validate method");
	}
	
	
	public void getAllProducts(){
		System.out.println("getting all products");
	}
}
