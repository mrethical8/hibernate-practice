package com.telusko.DemoHib;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.EntityManager;

import org.hibernate.Transaction;

public class App {
	public static void main(String[] args) {

		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Laptop.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Alien a1 = session.find(Alien.class , 1);
		
		System.out.println(a1.getAname()); 
//		Collection<Laptop> laps = a1.getLaps();
//		
//		for(Laptop l : laps)
//		{
//			System.out.println(l);
//		}
		 
		session.getTransaction().commit(); 

		session.close(); 
	}
}

 