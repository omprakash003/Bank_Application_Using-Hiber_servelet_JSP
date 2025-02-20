package Auth;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entities.admin;
import conn.Hibernateadmin;

public class adminauth {
	
	public boolean verify(SessionFactory ses, String username, int pass) {
		Session session=ses.openSession();
		try {
            Query<admin> query = session.createQuery(
                "FROM admin WHERE username = :username", admin.class);
            query.setParameter("username", username);

            admin a1 = query.uniqueResult(); // Fetch the admin record

            if (a1 == null) {
                System.out.println("Error: No admin found with username: " + username);
                return false; // Username does not exist
            }

            System.out.println("Fetched Admin Details: Username: " + a1.getUsername() + ", Password: " + a1.getPassword());
            System.out.println("Input Password: " + pass);

            // Ensure password comparison is correct
            if (a1.getPassword() == pass) {
                
                return true;
            } else {
                
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
        	if(session!=null) {
            session.close();
        	}
        }
	}
    }

		

	
	


