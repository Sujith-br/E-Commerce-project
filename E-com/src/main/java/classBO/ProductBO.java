package classBO;

import java.util.List;

import classDAO.ProductDAO;
import javaDemo.E_com.Product;
import javaDemo.E_com.User;


public class ProductBO {
	ProductDAO productDao = new ProductDAO();
    
    public void insert(Product product) {
    	productDao.insert(product);
    }
    
    public Product checkProduct(String product) {
		Product checkProduct = null;
		List<Product> checkProductList = productDao.list();
		for(int i = 0 ; i < checkProductList.size(); i++) {
			if(product.equalsIgnoreCase(checkProductList.get(i).getName())) {
				checkProduct = checkProductList.get(i);
			}
		}
		return checkProduct;
		   
	   }
}
