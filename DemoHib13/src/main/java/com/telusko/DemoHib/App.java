package com.telusko.DemoHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import jakarta.persistence.EntityManager;

import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App { 
	public static void main(String[] args) { 

		Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		//Laptop lap = session.find(Laptop.class,6);//get is deprecated we use find //get will give you the object
		//Laptop lap = session.load(Laptop.class, 6);//we are getting error in this ignore //load will give you the proxy object
		//System.out.println(lap);
		
        session.getTransaction().commit();		
		session.close(); 
		
		//Note:always use get to fetch data and incase if you want to pass proxy object then use load
	}
}

 