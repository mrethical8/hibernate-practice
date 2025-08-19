package com.telusko.DemoHib;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import jakarta.persistence.EntityManager;

import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App {
	public static void main(String[] args) {

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		//1)to create table values
//		Random r = new Random();
//		  
//		for(int i=1;i<=50;i++)
//		{
//			Student s = new Student();
//			s.setRollno(i);
//			s.setName("Name "+i);
//			s.setMarks(r.nextInt(100));
//			session.persist(s);
//		}
		
		
		//2)after creating use this to update add inside hibxml and then use this
		
		//Query<Student> q = session.createQuery("from Student",Student.class);
		//Query<Student> q = session.createQuery("from Student where marks > 50",Student.class);
		//List<Student> students = q.list();
//		for(Student s : students)
//		{
//			System.out.println(s);
//		}
		
		//or
		
		Query<Student> q = session.createQuery("from Student where rollno = 7",Student.class);
		Student student = (Student)q.uniqueResult();
		
		System.out.println(student); 
	
		
        session.getTransaction().commit();		
		session.close(); 
	}
}

 