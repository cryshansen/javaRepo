package bll;

import dao.ProductDao;

public class ProductManager {

	private ProductDao productDao = util.SpringFactory.getProductDao();
	
	
	public java.util.List<entity.Product> findProductsByAny(String keyword) {
		return productDao.findProductsByAny(keyword);
	}
	
	public java.util.List<entity.Product> findProductsByAll(java.util.Hashtable<String, String> searchTable) {
		return productDao.findProductsByAll(searchTable);
	}
	
}

