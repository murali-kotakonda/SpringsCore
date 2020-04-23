package issue;

public class TestProdcuctController {
	public static void main(String[] args) {
		ProductController controller = new ProductController();
		
		ProductService service = new ProductService();
		//keep service obj inside controller obj
		controller.service=service;
				
		ProductHelper helper = new ProductHelper();
		//keep dao inside product service
		service.helper = helper;
				
		ProductDAO daoObj = new ProductDAO();
		//keep dao inside helper
		helper.dao= daoObj;
		
		controller.process();
	}
}
