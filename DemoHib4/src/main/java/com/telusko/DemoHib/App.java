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
		
		Laptop laptop = new Laptop();
		laptop.setLid(101);
		laptop.setLname("Dell");
		 
		Student s = new Student();
		s.setName("Shubham");  
		s.setRollno(1);
		s.setMarks(56); 
		//s.setLaptop(laptop);//for onetoone
		//s.getLaptop().add(laptop);//for onetomany 
		laptop.getStudent().add(s);//manytomany

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.persist(laptop);
		session.persist(s);
		
        session.getTransaction().commit();		
		session.close(); 
	}
}

 