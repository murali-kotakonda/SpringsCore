package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class ProductService {
	@Autowired
	IntegrationService service;

	/*
	 * @Transactional public Product add(Product product) { return dao.add(product);
	 * }
	 * 
	 * @Transactional public boolean getProduct(Product product) {
	 * 
	 * Product pdtById = dao.getpdtById(product.getArticleId()); if (pdtById ==
	 * null) { return false; } return dao.getProduct(product); }
	 * 
	 * @Transactional public Product getPdtById(int id) { return dao.getPdtById(id);
	 * }
	 * 
	 * @Transactional public boolean deleteProduct(Product product) { // check if
	 * the employee exists Product pdtById = dao.getPdtById(product.getArticleId());
	 * 
	 * // if the employee doesn't exists then don't make db call, just return false;
	 * if (pdtById == null) { return false; } return dao.deleteProduct(product);
	 * 
	 * }
	 * 
	 * @Transactional public Product updateProduct(Product product) { return
	 * dao.updateProduct(product); }
	 */
	@Transactional
	public List<Product> getProducts() {
		return service.getProductList();
	}

}
