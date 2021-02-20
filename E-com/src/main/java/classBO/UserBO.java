package classBO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import classDAO.UserDAO;
import javaDemo.E_com.User;

public class UserBO {
	
	UserDAO userDao = new UserDAO();
	    
	    public void insert(User user) {
	    	userDao.insert(user);
	    }
	    
	    
		public List<User> listOfUsers() {
			
	        List<User> userList = new ArrayList<User>();
	        userList = userDao.list();
	        return userList;
		}
	    
	    public void update(User user) {
	         userDao.update(user);
	    }
	    
	    public void adminDisplay() {
	    	System.out.println("1. Create a User\n2. Update a user\n3. Add an Address\n4. Update an Address\n5. Add a product\n6. Update a product");
	    	System.out.println("Enter a number");
	    }
	    
	    public void customerDisplay() {
	    	System.out.println("1. Purchase products\n2. Purchase History\n3. Show product wise purchase history\n4. Rate a product\n5. Check ratings for a product");
	    	System.out.println("Enter a number");
	    }
	    
	    
	    
	   public User checkUser(String user) {
		User checkUser = null;
		List<User> checkUserList = userDao.list();
		for(int i = 0 ; i < checkUserList.size(); i++) {
			if(user.equals(checkUserList.get(i).getUserName())) {
				checkUser = checkUserList.get(i);
			}
		}
		return checkUser;	   
	   }
	   
	   public Boolean checkEmail(String email) {
		   Boolean mail = false;
		   List<User> checkUserList = userDao.list();
		   for(int i = 0 ; i < checkUserList.size(); i++) {
			   if(email.equals(checkUserList.get(i).getEmail())) {
				   mail = true;
			   }
		   }
		   return mail;
	   } 
	   
	  
	   public Boolean checkUserNAme(String userName) {
		   Boolean name = false;
		   List<User> checkUserList = userDao.list();
		   for(int i = 0 ; i < checkUserList.size(); i++) {
			   if(userName.equals(checkUserList.get(i).getUserName())) {
				   name = true;
			   }
		   }
		   return name;
	   }
	   
	   public Boolean spaceAndLengthCheck(String string) {
		   Boolean value = false;
		   string = string.trim();
		   if(string.length()==0) {
			   value = true;
		   }
		   return value;
	   }
	   
	   public Boolean emailValidation(String email) {
		   Boolean mail = true;
		   String regex = "^(.+)@(.+)$";
		   
		   if(email.matches(regex)) {
			   mail = false;
		   }
		return mail;
		   
	   }
	 
}



	


