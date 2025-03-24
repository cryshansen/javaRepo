package entity;

import java.math.BigDecimal;
import javax.persistence.*;
import org.hibernate.annotations.AccessType;

/**
 * This is the persistence POJO (Plain Ordinary Java Object) mapping to the database table "offices"
 * using Hibernate 3 Annotations.
 * 
 * @author Crystal Hansen
 * May 29 2020
 */
@Entity
@Table(name="products")
@AccessType("field")
public class Product implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(length=15)
	private String productCode;
    private String productName;
    @ManyToOne
    @JoinColumn(name="productLine")
    private ProductLine productLine;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private int quantityInStock;
    private BigDecimal buyPrice;
    private BigDecimal msrp;

    public Product() {
    }

	
    public Product(String productCode) {
        this.productCode = productCode;
    }
    public Product(String productCode, String productName, ProductLine productLine, String productScale, String productVendor, String productDescription, int quantityInStock, BigDecimal buyPrice, BigDecimal msrp) {
       this.productCode = productCode;
       this.productName = productName;
       this.productLine = productLine;
       this.productScale = productScale;
       this.productVendor = productVendor;
       this.productDescription = productDescription;
       this.quantityInStock = quantityInStock;
       this.buyPrice = buyPrice;
       this.msrp = msrp;
    }
   
    public String getProductCode() {
        return this.productCode;
    }
    
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public String getProductName() {
        return this.productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public ProductLine getProductLine() {
        return this.productLine;
    }
    
    public void setProductLine(ProductLine productLine) {
        this.productLine = productLine;
    }
    public String getProductScale() {
        return this.productScale;
    }
    
    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }
    public String getProductVendor() {
        return this.productVendor;
    }
    
    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }
    public String getProductDescription() {
        return this.productDescription;
    }
    
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    public int getQuantityInStock() {
        return this.quantityInStock;
    }
    
    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
    public BigDecimal getBuyPrice() {
        return this.buyPrice;
    }
    
    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }
    public BigDecimal getMsrp() {
        return this.msrp;
    }
    
    public void setMsrp(BigDecimal msrp) {
        this.msrp = msrp;
    }




}


