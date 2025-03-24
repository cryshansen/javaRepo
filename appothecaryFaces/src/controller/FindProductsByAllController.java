package controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.*;
import bll.ProductManager;

public class FindProductsByAllController {

	private String productCode;
	private String productName;
	private String productDescription;
	private String productVendor;
	private String productScale;
	private String productLine;
	
	private ProductManager productManager = new ProductManager();
	/** used to populate the dataTable control */
	private DataModel products = new ListDataModel();
	
	/** This is event-handler for the Search button */
	public String findProducts() {
		String outcome = "success";
		java.util.Hashtable<String, String> searchTable = new java.util.Hashtable<String, String>();
		if( productCode != null && !productCode.trim().equals("") ) {
			searchTable.put("productCode", productCode);
		}
		if( productName != null && !productName.trim().equals("") ) {
			searchTable.put("productName", productName);
		}
		if( productDescription != null && !productDescription.trim().equals("") ) {
			searchTable.put("productDescription", productDescription);
		}
		if( productVendor != null && !productVendor.trim().equals("") ) {
			searchTable.put("productVendor", productVendor);
		}
		if( productScale != null && !productScale.trim().equals("") ) {
			searchTable.put("productScale", productScale);
		}
		if( productLine != null && !productLine.trim().equals("") ) {
			searchTable.put("productLine", productLine);
		}
		java.util.List<entity.Product> productList = productManager.findProductsByAll(searchTable);
		if( productList.size() == 0 ) {
			products.setWrappedData( null );
			FacesMessage msg = new FacesMessage("No records found");
			msg.setSeverity(FacesMessage.SEVERITY_WARN);
			FacesContext.getCurrentInstance().addMessage("searchForm",  msg);
		} else {
			products.setWrappedData( productList );
			FacesMessage msg = new FacesMessage("Found " + productList.size()	+ " records.");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage("searchForm",  msg);
		}
		return outcome;
	}
	
	public DataModel getProducts() {
		return products;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductVendor() {
		return productVendor;
	}

	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	public String getProductScale() {
		return productScale;
	}

	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}

	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public void setProducts(DataModel products) {
		this.products = products;
	}
	
	
	
	
}
