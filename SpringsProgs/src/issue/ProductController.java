package issue;

public class ProductController {

	ProductService service;
	ProductValidator validator;
	
	
	public void process(){
		System.out.println("entering ProductController.proces method");
		service.validate();
		validator.processValidation();
		System.out.println("exit ProductController.proces method");
	}
	
}
