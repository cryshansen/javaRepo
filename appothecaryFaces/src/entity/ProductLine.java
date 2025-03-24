package entity;

import java.sql.Blob;

public class ProductLine  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String productLine;
    private String textDescription;
    private String htmlDescription;
    private Blob image;

    public ProductLine() {
    }

	
    public ProductLine(String productLine) {
        this.productLine = productLine;
    }
    public ProductLine(String productLine, String textDescription, String htmlDescription, Blob image) {
       this.productLine = productLine;
       this.textDescription = textDescription;
       this.htmlDescription = htmlDescription;
       this.image = image;
    }
   
    public String getProductLine() {
        return this.productLine;
    }
    
    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }
    public String getTextDescription() {
        return this.textDescription;
    }
    
    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }
    public String getHtmlDescription() {
        return this.htmlDescription;
    }
    
    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }
    public Blob getImage() {
        return this.image;
    }
    
    public void setImage(Blob image) {
        this.image = image;
    }




}


