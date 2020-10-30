package issue;

public class TestProuct {
	public static void main(String[] args) {

		//Create ProductController obj
		ProductController c = new ProductController();
		
		//create product service obj
		ProductService serviceObj = new ProductService();

		//keep service obj inside controller obj
		c.service = serviceObj;

		//create ProductHelper obj
		ProductHelper helperObj = new ProductHelper();
		
		//keeep helper obj inside service obj
		serviceObj.helper = helperObj;
		
		//create obj for ProductDAO
		ProductDAO daoObj = new ProductDAO();
		
		//keep dao inside helper
		helperObj.dao = daoObj;
		
		//call the process() method
		c.process();
		
	}
}
