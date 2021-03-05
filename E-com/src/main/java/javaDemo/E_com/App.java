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
    	String userName="";
    	do {
    		System.out.println("Enter User Name:");
        	 userName = br.readLine();
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
	    			User newUser = new User();
	    			do {
	    				
	    				System.out.println("Name:");
				    	newUser.setName(br.readLine());
				    	
				    	checkEmail(newUser);
				    	
				    	mobileNumberValidate(newUser);
				    	
				    	checkUserName(newUser);
				    	
				    	checkPassword(newUser);
				    	
				    	System.out.println("Role:");
				    	newUser.setRole(br.readLine());
				    	
				    	
		    			
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
		    				
			    			System.out.println("Enter the username:");
			    			String userNameCheck = br.readLine();
			    			
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
					        	    	    		System.out.println("Enter new name :");
					        	    	    		updateUser.setName(br.readLine());
					        	    	    		userBO.update(updateUser);
					        	    	    		break;
					        	    	    		
					        	    	    	case 2:
					        	    	    		checkEmail(updateUser);
					        	    	    		break; 
					        	    	    		
					        	    	    	case 3:
					        	    	    		mobileNumberValidate(updateUser);
					        	    	    		break;
					        	    	    		
					        	    	    	case 4:
					        	    	    		
					        	    	    		checkUserName(updateUser);
					        	    	    		break;
					        	    	    		
					        	    	    	case 5:
					        	    	    		checkPassword(updateUser);
					        	    	    		break;
					            	    	}
					            	    	
					            	    	System.out.println("Do you want to update another field(Yes/No");		        
				            			}while(br.readLine().equalsIgnoreCase("Yes"));     			
			            		}
			            	 			
			    			System.out.println("Do you want to update another user(Yes/No");
		    			}while( br.readLine().equalsIgnoreCase("Yes"));
						
	    			}while(flag==0);
	    			break;
	    		case 3:
	    			
	    			Integer flag1=0;
	    			//do {
			    			do {
				    			System.out.println("Enter the Username of the user to add address");
				    			String userNameCheck1= br.readLine();
	
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
    		userBO.customerDisplay();
    		List<Product> cartList = new ArrayList<Product>();
    		
    		switch(Integer.parseInt(br.readLine())) {
    		
    		case 1:
    			List<Product> productList = new ArrayList<Product>();
    			productList = productBO.listOfProducts();
    			Integer count1 = 0;
    			do {
	    			for(int i = 0;i<productList.size();i++) {
	    				System.out.println(productList.get(i).getName());
	    			}	    			
	    			do {
    					System.out.println("Enter the name of the product to purchase");
    					String searchProduct = br.readLine();			   			
			    		for(int i = 0;i<productList.size();i++) {
			    			if(searchProduct.equalsIgnoreCase(productList.get(i).getName())) {
			    			 System.out.println(productList.get(i).getBrand()+"  "+productList.get(i).getColour()+"  "+productList.get(i).getPrice());
			    			 Product buyProduct = new Product();
		   					 buyProduct.setName(productList.get(i).getName());
		   					 buyProduct.setBrand(productList.get(i).getBrand());
		   					 buyProduct.setColour(productList.get(i).getColour()); 
		   					 System.out.println("Enter the quantity of the product");
		   					 Integer quantity = Integer.parseInt(br.readLine());
		   					 buyProduct.setQuantity(quantity);
		   					 buyProduct.setPrice(productList.get(i).getPrice()*quantity);
		   					 cartList.add(buyProduct);    
		   					 count1++;
			    		    }		 
						}
			    		if(count1==0) {
			    			System.out.println("Please enter correct product");
			    		}
	    			}while(count1<=0);
		    			System.out.println("Do you want to add more products to cart(Yes/No)");
    			}while(br.readLine().equalsIgnoreCase("Yes"));
    			System.out.println("Your cart List\n"+cartList);
    			Double totalPrice = 0.00;
    			for(int i = 0; i < cartList.size() ; i++) {
    				totalPrice += cartList.get(i).getPrice();
    			}
    			System.out.println("Total: "+totalPrice);
    			System.out.println("Select an address to proceed");
    			 List<Address> addressListOfUser = new ArrayList<Address>();
    			for(int i = 0; i< userList.size();i++) {
    				if(userName.equals(userList.get(i).getUserName())) {
    					 addressListOfUser = userList.get(i).getAddress();
    				}
    			}
    			System.out.println(addressListOfUser);
    			
    			
    			
    			
    			
    			
    			
    			
    			
    		} //switch closing
    	}//customer closing

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
	
	private static void checkUserName(User user)throws Exception{
		Boolean checkUserName = false;
		do {
			System.out.println("Enter Username:");
			String userName = br.readLine();
			Boolean checkName = userBO.checkUserNAme(userName);
			if(checkName) {
				System.out.println("username already exists. Enter new user name");
				checkName = true;
			}
			else {
				user.setUserName(userName);
				userBO.update(user);
				checkName = true;
			}
		}while(checkUserName);
	}
	
	private static void checkEmail(User user)throws Exception{
		Boolean checkEmail= false;
		do {
			System.out.println("Enter email:");
			String mail = br.readLine();
			
			Boolean lengthCheck = userBO.spaceAndLengthCheck(mail);
			if(lengthCheck) {
				System.out.println("Enter valid email address");
				checkEmail = true; 
			}
			else {
				Boolean emailValidation = userBO.emailValidation(mail);
				if(emailValidation) {
					System.out.println("Enter valid email address");
					checkEmail = true;
				}
				else {
					Boolean emailCheck= userBO.checkEmail(mail);
					if(emailCheck) {
						System.out.println("email already exists. Enter valid email");
						checkEmail = true;
					}
					else {
						user.setEmail(mail);
						userBO.update(user);
						checkEmail = false;
					}
					
				}
				
			}
		}while(checkEmail);
	}
	
	private static void checkPassword(User user)throws Exception{
		Boolean checkPassword= false;
		do {
			System.out.println("Enter password:");
			String password = br.readLine();
			
			Boolean lengthCheck = userBO.spaceAndLengthCheck(password);
			if(lengthCheck) {
				System.out.println("Invalid Password. Password must contain atleast one lowercase, one upper case and one number");
				checkPassword = true; 
			}
			else {
				Boolean passwordValidate = userBO.passwordValidation(password);
				if(passwordValidate) {
					System.out.println("Invalid Password. Password must contain atleast one lowercase, one upper case and one number");
					checkPassword = true;
				}
				else {
					user.setPassword(password);
					userBO.update(user);
					checkPassword = false;
				}
					
			}
				
		}while(checkPassword);
	}
	
	private static void mobileNumberValidate(User user) throws Exception {
		Boolean checkNumber = false;
		do {
			System.out.println("Enter mobile number:");
			String mobileNumber = br.readLine();
			
			Boolean lengthCheck = userBO.spaceAndLengthCheck(mobileNumber);
			if(lengthCheck) {
				System.out.println("Invalid mobile number");
				checkNumber = true; 
			}
			else {
				Boolean mobileNumberValidate = userBO.mobileNumberValidation(mobileNumber);
				if(mobileNumberValidate) {
					System.out.println("Mobile number must begin with 7-9 and there must be 10 digits");
					checkNumber = true;
				}
				else {
					user.setMobileNumber(mobileNumber);
					userBO.update(user);
					checkNumber = false;
				}
					
			}
				
		}while(checkNumber);
	}
	

}
