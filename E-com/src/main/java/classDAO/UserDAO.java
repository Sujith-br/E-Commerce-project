 package classDAO;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import javaDemo.E_com.Address;
import javaDemo.E_com.User;

public class UserDAO {
	
	Configuration con = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(Address.class);
    ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    SessionFactory sf = con.buildSessionFactory(reg);
 
	User user = null;
	    public void update(User user) {
	    	Session ses = sf.openSession();
	        Transaction t = ses.beginTransaction();
	        ses.saveOrUpdate(user);
	        t.commit();
	        ses.close();
	        
	        
		}
	    public void insert(User user) {
	    	Session ses = sf.openSession();
	        Transaction t = ses.beginTransaction();
	        ses.save(user);
	        t.commit();
	        ses.close();
	    }
	    public List<User> list() {
			Session ses = sf.openSession();
	        Transaction t = ses.beginTransaction();
	         List<User> userList = new ArrayList<User>();
	         userList = ses.createCriteria(User.class).list();
	        t.commit();
	        ses.close(); 
	        return userList;
		}
}
