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
		
		Laptop l = new Laptop();//it is in Transient state
		l.setLid(52);
		l.setBrand("Lenonvo");
		l.setPrice(800);
		
		session.persist(l);//persistent state
		
		l.setPrice(750); //so whatever you make changes with object it reflected in database  // transient to persistent state
		
		session.remove(l);//use delete() instead of remove() // removed state
		
		
        session.getTransaction().commit();		
		session.close(); 
		
		session.evict(l);//used evict instead of detach //now it is not not in persistent state it is in detached state
		l.setPrice(600);
	}
}

 