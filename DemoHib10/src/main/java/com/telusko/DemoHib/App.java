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

//1)//		Query<Object[]> q = session.createQuery("select rollno, marks, name from Student where rollno = :rollno",Object[].class);
//		q.setParameter("rollno", 7);
//
//		Object[] student = q.uniqueResult();
//
////		for (Object o : student) {
////			System.out.println(o);
////		}
//		
//		//or
//		
//		System.out.println(student[0] + " : " + student[1] + " : " + student[2]);
		
//2) 
  
//		Query<Object[]> q = session.createQuery("select rollno, marks, name from Student", Object[].class);
//		List<Object[]> students = q.getResultList();
//
//		for (Object[] student : students) 
//		    System.out.println(student[0] + " : " + student[1] + " : " + student[2]);

//3) 
		
//		Query<Object[]> q = session.createQuery("select rollno, marks, name from Student s where s.marks >60", Object[].class);
//		List<Object[]> students = q.getResultList();
//
//		for (Object[] student : students) 
//		    System.out.println(student[0] + " : " + student[1] + " : " + student[2]);
//

		
//4)
//		// For single scalar result, specify Long.class
//		Query<Long> q = session.createQuery("select sum(marks) from Student s where s.marks > 60", Long.class);
//
//		Long marks = q.uniqueResult();  // or q.getSingleResult() in Hibernate 6+
//
//		System.out.println(marks);
//
		
//5)	
		int b = 60;
		Query<Long> q = session.createQuery("select sum(marks) from Student s where s.marks > : b ", Long.class);
        q.setParameter("b",b);
		Long marks = q.uniqueResult();

		System.out.println(marks); 

		session.getTransaction().commit();
		session.close();
		
  }
}
