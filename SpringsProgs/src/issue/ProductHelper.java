package issue;

public class ProductHelper {

	ProductDAO dao;
	
	public void check(){
		System.out.println("entering ProductHelper check method");
		dao.save();
		System.out.println("exit ProductHelper check method");
	}
}
