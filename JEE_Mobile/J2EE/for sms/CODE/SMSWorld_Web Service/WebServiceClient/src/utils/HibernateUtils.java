package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtils {
	private static SessionFactory factory;
	
	static 
	{
		System.out.println("in static init block");
		factory=new AnnotationConfiguration().configure().buildSessionFactory();
	}
	public static SessionFactory getFactory() {
		return factory;
	}
	public static Session getSession()
	{
		return factory.openSession();
	}
	

}
