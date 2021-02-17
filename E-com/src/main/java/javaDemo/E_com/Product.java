package javaDemo.E_com;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="name")
    private String name;
	
	@Column(name="price")
    private Double price;
	
	@Column(name="colour")
    private String colour;
	
	@Column(name="brand")
    private String brand;
	
	@Column(name="quantity")
	private Integer quantity;
	
	public Product(String name, Double price, String colour, String brand, Integer quantity) {
		super();
		
		this.name = name;
		this.price = price;
		this.colour = colour;
		this.brand = brand;
		this.quantity = quantity;
	}
	public Product() {}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
}
