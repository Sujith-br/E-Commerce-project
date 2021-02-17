package javaDemo.E_com;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class PurchaseOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="purchase_date")
    private String purchasedDate;
	
	@Column(name="total_price")
    private Double totalPrice;
	
    @ManyToOne
    @JoinColumn(name="user_id") 
    private User user;
    
    @ManyToOne
    @JoinColumn(name="address_id")
    private Address address;
    
    @OneToMany(mappedBy="purchaseOrder")
    private List<PurchaseOrderItem> purchaseOrderItem = new ArrayList<PurchaseOrderItem>();
    
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPurchasedDate() {
		return purchasedDate;
	}
	public void setPurchasedDate(String purchasedDate) {
		this.purchasedDate = purchasedDate;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<PurchaseOrderItem> getPurchaseOrderItem() {
		return purchaseOrderItem;
	}
	public void setPurchaseOrderItem(List<PurchaseOrderItem> purchaseOrderItem) {
		this.purchaseOrderItem = purchaseOrderItem;
	}
	public PurchaseOrder( String purchasedDate, Double totalPrice) {
		super();
		
		this.purchasedDate = purchasedDate;
		this.totalPrice = totalPrice;
	}
}
	