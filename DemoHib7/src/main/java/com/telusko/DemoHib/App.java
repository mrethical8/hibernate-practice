package com.telusko.DemoHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App {
	public static void main(String[] args) {

		Alien a =null;
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);
		
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		a = (Alien) session.find(Alien.class, 101);//1st cache
		System.out.println(a);
		
		session.getTransaction().commit();
		session.close(); 
		
		Session session2 = sf.openSession();
		Transaction tx2 = session2.beginTransaction();
		
		a = (Alien) session2.find(Alien.class, 101);//second cache
		System.out.println(a);
		 
		session2.getTransaction().commit();
		session2.close();
		
	}
}

 