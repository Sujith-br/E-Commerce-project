package javaDemo.E_com;


import javax.persistence.*;

@Entity
public class PurchaseOrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="quantity")
    private Integer quantity;
	
	@Column(name="unit_price")
    private Double unitPrice;
	
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
    
    @ManyToOne
    @JoinColumn(name="purchase_order_id")
    private PurchaseOrder purchaseOrder;
    
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}
	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	public PurchaseOrderItem( Integer quantity, Double unitPrice) {
		super();

		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
    
}
