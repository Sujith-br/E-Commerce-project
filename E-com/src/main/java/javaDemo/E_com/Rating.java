package javaDemo.E_com;

import javax.persistence.*;

@Entity
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
	@Column(name="rating")
   private Integer rating;
	
   @ManyToOne
   @JoinColumn(name = "product_id")
   private Product product;
   
   @ManyToOne
   @JoinColumn(name = "user_id")
   private User user;
   
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Integer getRating() {
	return rating;
}
public void setRating(Integer rating) {
	this.rating = rating;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Rating(Long id, Integer rating) {
	super();
	this.id = id;
	this.rating = rating;
}
}
