package Ex2;

public class TestProductServiceWithoutSprings {
	public static void main(String[] args) {
		Product product = new Product();
		product.setId("1234");
		product.setDesc("test desc");
		product.setBrand("lifestyle");
		product.setProductName("shirt merun");
		
		ProductService ps = new ProductService();
		ps.save(product);
	}
}
