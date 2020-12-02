package issue;

public class ProductHelper {

	ProductDAO dao;// dao obj as instance variable
	
	public void check(){
		System.out.println("entering ProductHelper check method");
		dao.save();
		System.out.println("exit ProductHelper check method");
	}
}
