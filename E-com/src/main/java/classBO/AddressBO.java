package classBO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import classDAO.AddressDAO;
import javaDemo.E_com.Address;
import javaDemo.E_com.User;

public class AddressBO {
	
	AddressDAO addressDao = new AddressDAO();
	    
	    public void insertaddress(Address address) {
	    	addressDao.insert(address);
	    }
	    
	    public Address updateAddress(Address address) {
	    	return addressDao.update(address);
	    }
	    
        public Integer checkAddressnumber(Integer integer) {
        	
			return integer;
        	
        }
}
