package Auth;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Entities.admin;
import Entities.customer;

public class customauth {
	public customer getCustomer(SessionFactory sessionFactory, String cid) {
	    Session session = sessionFactory.openSession();
	    int userid = Integer.parseInt(cid.trim());
	    
	    try {
	        Query<customer> query = session.createQuery("FROM customer WHERE userid = :userid", customer.class);
	        query.setParameter("userid", userid);
	        
	        return query.uniqueResult();
	    } catch (Exception e) {
	        System.out.println("Error retrieving customer: " + e.getMessage());
	        return null;
	    } finally {
	        session.close();
	    }
	}
	public boolean updatetransaction(SessionFactory ses,int userid,int rid,Long amt,Long balance) {
		String uid=Integer.toString(userid);
		String sid=Integer.toString(rid);
		Session session = ses.openSession();
		Transaction tx=session.beginTransaction();
		try {
			System.out.println("getting c1");
			
			customer c1=getCustomer(ses,uid );
			System.out.println("C1 Name:");
			System.out.print(c1.getName());
			System.out.println("getting c2");
			customer c2=getCustomer(ses,sid );
			System.out.print(c2.getName());
			System.out.println("Setting Balance 1");
			c1.setBalance(c1.getBalance()-amt);
			System.out.println("Setting Balance 2");
			c2.setBalance(c2.getBalance()+amt);
			System.out.println("Balance set");
			System.out.println("Saving c1");
		session.saveOrUpdate(c1);
		System.out.println("Saving c2");
		session.saveOrUpdate(c2);
		System.out.println("Both saved...");
		tx.commit();
		return true;
			
			
			
			
		}
		catch(Exception e) {
			System.out.println("Not updated...");
		}
		return false;
	}

}
