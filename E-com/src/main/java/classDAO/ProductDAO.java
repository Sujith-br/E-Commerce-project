package classDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import javaDemo.E_com.Product;
import javaDemo.E_com.User;


public class ProductDAO {
	Configuration con = new Configuration().configure();
    ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    SessionFactory sf = con.buildSessionFactory(reg);
 
	Product product = null;
	    
	    public void insert(Product product) {
	    	Session ses = sf.openSession();
	        Transaction t = ses.beginTransaction();
	        ses.saveOrUpdate(product);
	        t.commit();
	        ses.close();
	    }
	    
	    public List<Product> list() {
			Session ses = sf.openSession();
	        Transaction t = ses.beginTransaction();
	         List<Product> productList = new ArrayList<Product>();
	         productList = ses.createCriteria(Product.class).list();
	        t.commit();
	        ses.close(); 
	        return productList;
		}
}
