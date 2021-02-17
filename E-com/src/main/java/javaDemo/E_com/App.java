package javaDemo.E_com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import classBO.AddressBO;
import classBO.ProductBO;
import classBO.UserBO;


public class App 
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static UserBO userBO = new UserBO();
	static AddressBO addressBO = new AddressBO();
	static ProductBO productBO = new ProductBO();
    public static void main( String[] args )throws Exception
    {
        
       // User user = new User();
       // Address address = new Address();
        
    	/*User user_admin = new User("Sujith","admin@gmail.com","9943895950","sujithbr","admin123","Admin");
    	User customer_1 = new User("rahul","rahul@gmail.com","9943895951","rahulsri","customer_1","Customer");
    	User customer_2 = new User("Gowri","gowri@gmail.com","7397675921","gowrish","customer_2","Customer");
    	User customer_3 = new User("prakash","prakash@gmail.com","1234567891","prakasharmi","customer_3","Customer");
    	
    	Address address_1 = new Address("L1","WkGardens","cbe","TN","pnPalayam","641017");
    	Address address_2 = new Address("L2","WkGardens","cbe","TN","pnPalayam","641017");
    	Address address_3 = new Address("L3","WkGardens","cbe","TN","pnPalayam","641017");
    	Address address_4 = new Address("L4","WkGardens","cbe","TN","pnPalayam","641017");
    	Address address_5 = new Address("L5","WkGardens","cbe","TN","pnPalayam","641017");
    	Address address_6 = new Address("L6","WkGardens","cbe","TN","pnPalayam","641017");
    	
    	customer_1.getAddress().add(address_1);
    	address_1.setUser(customer_1);
    	
    	customer_1.getAddress().add(address_2);
    	address_1.setUser(customer_1);
    	
    	customer_1.getAddress().add(address_3);
    	address_1.setUser(customer_1);
    	
    	customer_2.getAddress().add(address_4);
    	address_2.setUser(customer_2);
    	
    	customer_2.getAddress().add(address_5);
    	address_2.setUser(customer_2);
    	
    	customer_3.getAddress().add(address_6);
    	address_3.setUser(customer_3);
    	
    	address_1.setUser(customer_1);
    	address_2.setUser(customer_1);
    	address_3.setUser(customer_1);
    	address_4.setUser(customer_2);
    	address_5.setUser(customer_2);
    	address_6.setUser(customer_3);
    	
    	
    	userBO.insert(user_admin);
    	userBO.insert(customer_1);
    	userBO.insert(customer_2);
    	userBO.insert(customer_3);
    	
    	
    	addressBO.insertaddress(address_1);
    	addressBO.insertaddress(address_2);
    	addressBO.insertaddress(address_3);
    	addressBO.insertaddress(address_4);
    	addressBO.insertaddress(address_5);
    	addressBO.insertaddress(address_6);
    	    	
    	Product product_1 = new Product("shoe",1500.00,"black","Nike", 5);
    	Product product_2 = new Product("chair",2000.00,"white","Nilkamal",10);
    	Product product_3 = new Product("watch",2300.00,"grey","Fastrack",15);
    	ProductBO productBo = new ProductBO();
    	productBo.insert(product_1);
    	productBo.insert(product_2);
    	productBo.insert(product_3);*/
    	
        UserBO userBO = new UserBO();
       AddressBO addressBO = new AddressBO();
    	List<User> userList = new ArrayList<User>();
    	userList = userBO.listOfUsers();
    	Integer count = 0;
    	String role ="";
    	do {
    		System.out.println("Enter User Name:");
        	String userName = br.readLine();
        	System.out.println("Enter Password:");
        	String password = br.readLine();
        	
        	for(int i = 0 ; i < userList.size(); i++) {
        		if((userName.equals(userList.get(i).getUserName())) && (password.equals(userList.get(i).getPassword()))) {
        			role = userList.get(i).getRole();
        			count++;
        		}
        	}
        	
        	if(count == 0) {
        	    System.out.println("Invalid Username or passswrod");
        	}
        	
        	
    	}while(count<=0);
    	
    	if(role.equalsIgnoreCase("Admin")) {
    		
    		do {
    			userBO.adminDisplay();
	    		switch(Integer.parseInt(br.readLine())){
	    		
	    		case 1:
	    			
	    			do {
			    		System.out.println("Name:");
				    	String name = br.readLine();
				    	
				    	System.out.println("email:");
				    	String email = br.readLine();
				    	
				    	System.out.println("Mobile Number:");
				    	String mobileNumber = br.readLine();
				    	
				    	System.out.println("Username:");
				    	String userName = br.readLine();
				    	
				    	System.out.println("Password:");
				    	String password = br.readLine();
				    	
				    	System.out.println("Role:");
				    	String role1 = br.readLine();
				    	
				    	User newUser = new User(name,email,mobileNumber,userName,password,role1);
		    			
		    			System.out.println("Enter Address");
		    	    	
		    	    	System.out.println("Address Line 1:");
		    	    	String addressLine1 = br.readLine();
		    	    	
		    	    	System.out.println("Address Line 2:");
		    	    	String addressLine2 = br.readLine();
		    	    	
		    	    	System.out.println("City:");
		    	    	String city = br.readLine();
		    	    	
		    	    	System.out.println("State:");
		    	    	String state = br.readLine();
		    	    	
		    	    	System.out.println("Landmark:");
		    	    	String landmark = br.readLine();
		    	    	
		    	    	System.out.println("Pincode:");
		    	    	String pincode = br.readLine();
		    	    	
		    	    	Address newAddress = new Address(addressLine1,addressLine2,city,state,landmark,pincode);
		    			
		    			newUser.getAddress().add(newAddress);
		    			newAddress.setUser(newUser);
		    			
		    			userBO.insert(newUser);
		    			addressBO.insertaddress(newAddress);
		    			
		    			System.out.println("Do you want to add another user(Yes/No");		        
	    			}while(br.readLine().equalsIgnoreCase("Yes"));
	    			break;
	    			
	    		case 2:
	 
	    			Integer flag = 0;
	    			do {
						do {
		    				//Integer flag =0;
			    			System.out.println("Enter the username:");
			    			String userNameCheck = br.readLine();
			    			//List<User> updatedUserList = new ArrayList<User>();
			    			//updatedUserList = userBO.listOfUsers();
			    				
			            		if(userBO.checkUser(userNameCheck)==null) {
			            			System.out.println("Enter Valid Username");
			            			flag=0;
			            		}
			            		else {
			            			
				            			do {
				            				
					            			System.out.println("Select the field to update");
					            	    	System.out.println("1. Name\n2. email\n3. Mobile Number\n4. User Name\n5. Password\n");
					            	    	User updateUser = userBO.checkUser(userNameCheck);
					            	    	switch(Integer.parseInt(br.readLine())) {
					            	    	
					        	    	    	case 1:
					        	    	    		System.out.println("Enter new Name:");
					        	    	    		updateUser.setName(br.readLine());
					        	    	    		userBO.update(updateUser);
					        	    	    		break;
					        	    	    		
					        	    	    	case 2:
					        	    	    		System.out.println("Enter new email:");
					        	    	    		updateUser.setEmail(br.readLine());
					        	    	    		userBO.update(updateUser);
					        	    	    		break; 
					        	    	    		
					        	    	    	case 3:
					        	    	    		System.out.println("Enter new mobile Number :");
					        	    	    		updateUser.setMobileNumber(br.readLine());
					        	    	    		userBO.update(updateUser);
					        	    	    		break;
					        	    	    		
					        	    	    	case 4:
					        	    	    		
					        	    	    		System.out.println("Enter new User Name:");
					        	    	    		updateUser.setUserName(br.readLine());
					        	    	    		userBO.update(updateUser);
					        	    	    		break;
					        	    	    		
					        	    	    	case 5:
					        	    	    		System.out.println("Enter new Password:");
					        	    	    		updateUser.setPassword(br.readLine());
					        	    	    		userBO.update(updateUser);
					        	    	    		break;
					            	    	}
					            	    	
					            	    	System.out.println("Do you want to update another field(Yes/No");		        
				            			}while(br.readLine().equalsIgnoreCase("Yes"));     			
			            		}
			            	 			
			    			System.out.println("Do you want to update another user(Yes/No");
		    			}while( br.readLine().equalsIgnoreCase("Yes"));
						//System.out.println("Do you want to update another user(Yes/No");
					    //answer1 = br.readLine();
	    			}while(flag==0);
	    			break;
	    		case 3:
	    			
	    			Integer flag1=0;
	    			//do {
			    			do {
				    			System.out.println("Enter the Username of the user to add address");
				    			String userNameCheck1= br.readLine();
				    			
				    			//updatedUserList1= userBO.listOfUsers();
				    				
				            		if(userBO.checkUser(userNameCheck1)==null) {
				            			System.out.println("Enter Valid Username");
				            			flag1=0;
				            		}
			    			
				            		else {
				            			flag1=1;
										do {
					            			System.out.println("Enter Address");
					    	    	    	
					    	    	    	System.out.println("Address Line 1:");
					    	    	    	String addressLine1 = br.readLine();
					    	    	    	
					    	    	    	System.out.println("Address Line 2:");
					    	    	    	String addressLine2 = br.readLine();
					    	    	    	
					    	    	    	System.out.println("City:");
					    	    	    	String city = br.readLine();
					    	    	    	
					    	    	    	System.out.println("State:");
					    	    	    	String state = br.readLine();
					    	    	    	
					    	    	    	System.out.println("Landmark:");
					    	    	    	String landmark = br.readLine();
					    	    	    	
					    	    	    	System.out.println("Pincode:");
					    	    	    	String pincode = br.readLine();
					    	    	    	
					    	    	    	Address addAddress = new Address(addressLine1,addressLine2,city,state,landmark,pincode);
					    	    	    	User newAddressForUser = userBO.checkUser(userNameCheck1);
											newAddressForUser.getAddress().add(addAddress);
											addAddress.setUser(newAddressForUser);
					            		    userBO.update(newAddressForUser);
					            		    addressBO.insertaddress(addAddress);
					            		    System.out.println("Do you want to add another address for the user?(YES/NO)");           		    
				            			}while(br.readLine().equalsIgnoreCase("Yes"));
										System.out.println("Do you want to add address to another user?(YES/NO)");            	    
				            		}
				            		
			    			}while(br.readLine().equalsIgnoreCase("Yes")  || flag1==0);
	    			//}while();
	    			
				    break;
				    
	    		case 4:
	    			Integer flag2 = null ;
	    			do {
		    			System.out.println("Enter the username of the user ");
		    			String userNameCheck2= br.readLine();
		 			
		            	if(userBO.checkUser(userNameCheck2)==null) {
		            			System.out.println("Enter Valid Username"); 
		            			flag2=0;
		            		}
					
		            	else {
		            		flag2 = 1;
		            		User updateAddressforUser = userBO.checkUser(userNameCheck2);
		            		if(updateAddressforUser.getAddress().size()==0) {
		            			System.out.println("No Address found");
		            		}
		            		else {
			            		for(int i = 0; i< updateAddressforUser.getAddress().size(); i++) {
			            			System.out.println((i+1)+". "+updateAddressforUser.getAddress().get(i));
			            		}
			            		do {
			            		System.out.println("Select the address number to update");
			            		Integer choice =  Integer.parseInt(br.readLine());
			            		updateAddress(updateAddressforUser, updateAddressforUser.getAddress().get(choice-1));
			            		System.out.println("Do you want to update any other address(Yes/No)");
			            		}while(br.readLine().equalsIgnoreCase("Yes"));            		
		            		}
		            	}
		            	System.out.println("Do you want to update address for other user?(Yes/No)");
	    			}while(br.readLine().equalsIgnoreCase("Yes") || flag2==0);
	    			break;
	    		
	    		case 5:
	    			do {
		    			System.out.println("Enter the product details:");
					    Product createProduct = new Product();
					    createProduct(createProduct);
					    System.out.println("Do you want to add another product(Yes/No)");
	    			}while(br.readLine().equalsIgnoreCase("Yes"));
	    			break;
	    			
	    		case 6:
	    			Integer flag3 = null;
					do {
		    			System.out.println("Enter the product name:");
		    			String productNameCheck= br.readLine();
			 			
		            	if(productBO.checkProduct(productNameCheck)==null) {
		            			System.out.println("Product does not exist"); 
		            			flag3=0;
		            		}
		            	else {
		            		flag3 = 1;
		            		Product productStockUpdate = productBO.checkProduct(productNameCheck);
		            		System.out.println("Enter the quantity to be updated");
		            		Integer quantity = Integer.parseInt(br.readLine());
		            		productStockUpdate.setQuantity(productStockUpdate.getQuantity()+quantity);
		            		productBO.insert(productStockUpdate);
		            	}
		            	System.out.println("Do you want to update stock for other product?(Yes/No)");
	    			}while(br.readLine().equalsIgnoreCase("yes") || flag3 == 0);
					break;
	    		}
	    		System.out.println("Go Back to main menu(Yes/No)");
    		}while(br.readLine().equalsIgnoreCase("yes")); //admin closing
    	}// admin closing
    	
    	
    	else if(role.equalsIgnoreCase("Customer")) {
    		userBO.customerDisplay();;
    	}

}
	private static void updateAddress(User user, Address address) throws Exception {
		System.out.println("Address Line 1:");
		address.setAddressLine1(br.readLine());
		System.out.println("Address Line 2:");
		address.setAddressLine2(br.readLine());
		System.out.println("city:");
		address.setCity(br.readLine());
		System.out.println("State:");
		address.setState(br.readLine());
		System.out.println("Landmark:");
		address.setLandmark(br.readLine());
		System.out.println("Pincode:");
		address.setPincode(br.readLine());
		addressBO.updateAddress(address);
		userBO.update(user);
	}
	
	private static void createProduct(Product product) throws Exception {
		System.out.println("Name:");
		product.setName(br.readLine());
		System.out.println("Colour:");
		product.setColour(br.readLine());
		System.out.println("Price:");
		product.setPrice(Double.parseDouble(br.readLine()));
		System.out.println("Brand:");
		product.setBrand(br.readLine());
		System.out.println("Quantity:");
		product.setQuantity(Integer.parseInt(br.readLine()));
		productBO.insert(product);
	}
}
