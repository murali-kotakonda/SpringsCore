package issue;

/**
  Create obj for ProductController and call the process() method. 
 */
public class TestProdcuctController {
	public static void main(String[] args) {
		ProductController controller = new ProductController();
		
		//create service obj
		ProductService service = new ProductService();
		//keep service obj inside controller obj
		controller.service=service;
				
		//create helper obj
		ProductHelper helper = new ProductHelper();
		//keep dao inside product service
		service.helper = helper;
				
		//create dao obj
		ProductDAO daoObj = new ProductDAO();
		//keep dao inside helper
		helper.dao= daoObj;
		
		controller.process();
	}
}
