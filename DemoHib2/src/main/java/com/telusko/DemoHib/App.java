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
		
		Alien telusko = null;

		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
		
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();//abhi k latest version mein hum standardserviceregistrybuilder  use krte hai aur build 

		SessionFactory sf = con.buildSessionFactory(reg);
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		// Replace deprecated get() with find()
		telusko = session.find(Alien.class, 3);
		
		tx.commit();
		
		System.out.println(shubham);

		session.close(); 
	}
}

 