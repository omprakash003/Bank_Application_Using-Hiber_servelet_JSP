package doa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Entities.customer;

public class customerdoa {
	private SessionFactory sessionFactory;
	public customerdoa(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	public boolean savecustomer(customer c) {
		boolean f=false;
		Session s=sessionFactory.openSession();
		Transaction tx=s.beginTransaction();
		
		int i=(Integer)s.save(c);
		tx.commit();
		if(i>0) {
			f=true;
		}
		return f;
		
	}

}
