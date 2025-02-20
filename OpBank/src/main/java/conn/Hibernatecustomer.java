package conn;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import Entities.admin;
import Entities.customer;

public class Hibernatecustomer {
	private static SessionFactory sessionfactory;
	public static SessionFactory getsessionFactory() {
		if(sessionfactory==null) {
			Configuration conf=new Configuration();
			Properties prop=new Properties();
			prop.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			prop.put(Environment.URL,"jdbc:mysql://localhost:3306/customerdata");
			prop.put(Environment.USER, "root");
			prop.put(Environment.PASS, "Omprakash@123");
			prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
			prop.put(Environment.HBM2DDL_AUTO, "update");
			prop.put(Environment.SHOW_SQL, true);
			conf.setProperties(prop);
			conf.addAnnotatedClass(customer.class);
			ServiceRegistry serviceregistry=new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
			sessionfactory=conf.buildSessionFactory(serviceregistry);
		}
		return sessionfactory;
	}
	public static void shutdown() {
        if (sessionfactory != null) {
            sessionfactory.close();  // Close SessionFactory when the application shuts down
        }
    }
}
