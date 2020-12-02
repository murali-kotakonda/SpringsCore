package issue;

/**
ProductController            ProductService                   ProductHelper                  ProductDAO
   process()   -------------->   validate() ------------------>  check()  -------------------->save()
  
 */
public class ProductController {

	ProductService service;// service obj as instance variable
	
	public void process(){
		System.out.println("entering ProductController.proces method");
		service.validate();
		System.out.println("exit ProductController.proces method");
	}
	
}
