package issue;

public class ProductService {

	ProductHelper helper;// helper obj as instance variable
	
	public void validate(){
		System.out.println("entering ProductService.validate method");
		helper.check();
		System.out.println("exit ProductService.validate method");
	}
	
	
	public void getAllProducts(){
		System.out.println("getting all products");
	}
}
