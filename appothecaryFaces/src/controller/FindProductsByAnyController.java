package controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.*;
import bll.ProductManager;

/**
 * This class is the "code-behind" for "findProductsByAny.jsp".
 * This class is to handle events generated from the JSP and
 * used to bind data to the controls in the JSP.
 * @author swu
 *
 */
public class FindProductsByAnyController {

	/** The keyword to search by */
	private String keyword;
	private ProductManager productManager = new ProductManager();
	/** used to populate the dataTable control */
	private DataModel products = new ListDataModel();
	
	/** This is event-handler for the Search button */
	public String findProducts() {
		String outcome = "success";
		java.util.List<entity.Product> productList = productManager.findProductsByAny(keyword);
		if( productList.size() == 0 ) {
			products.setWrappedData( null );
			FacesMessage msg = new FacesMessage("No records found matching '" + keyword + "'");
			msg.setSeverity(FacesMessage.SEVERITY_WARN);
			FacesContext.getCurrentInstance().addMessage("searchForm",  msg);
		} else {
			products.setWrappedData( productList );
			FacesMessage msg = new FacesMessage("Found " + productList.size() 
					+ " records found matching '" + keyword + "'");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage("searchForm",  msg);
		}
		return outcome;
	}
	
	public DataModel getProducts() {
		return products;
	}
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}	
	
}
