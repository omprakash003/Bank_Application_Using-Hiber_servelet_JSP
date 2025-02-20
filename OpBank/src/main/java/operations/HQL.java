package operations;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Entities.customer;
import java.util.*;
import conn.Hibernatecustomer;

public class HQL {
	public static void main(String[] args) {
		SessionFactory sessionFactory=Hibernatecustomer.getsessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="UPDATE customer c SET c.balance=1000 where c.userid=:uid";
		Query query=session.createQuery(hql);
		query.setParameter("uid", 1233);
		int updated=query.executeUpdate();
		tx.commit();
		System.out.println("updated rows"+updated);
	}


}
