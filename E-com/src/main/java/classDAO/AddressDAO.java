package classDAO;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import javaDemo.E_com.Address;
import javaDemo.E_com.User;

public class AddressDAO {
	private static final Session HibernateUtil = null;
	Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
    ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    SessionFactory sf = con.buildSessionFactory();
    
	Address address = null;
	    public Address update(Address address) {
	    	Session ses = sf.openSession();
	        Transaction t = ses.beginTransaction();
	        ses.update(address);
	        t.commit();
	        ses.close();
	        return address;
	        
		}
	    public void insert(Address address) {
	    	Session ses = sf.openSession();
	        Transaction t = ses.beginTransaction();
	        ses.save(address);
	        t.commit();
	        ses.close();
}
}
