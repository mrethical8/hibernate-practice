package com.telusko.DemoHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
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
		Query q1 = session.createQuery("from Alien where aid=101");
		q1.setCacheable(true);
		a = (Alien)q1.uniqueResult();
		System.out.println(a);
		
		session.getTransaction().commit();
		session.close(); 
		
		Session session2 = sf.openSession();
		Transaction tx2 = session2.beginTransaction();
		Query q2 = session2.createQuery("from Alien where aid=101");
		q2.setCacheable(true);
		a = (Alien)q2.uniqueResult();
		System.out.println(a);
		 
		session2.getTransaction().commit();
		session2.close();
		
	}
}

 