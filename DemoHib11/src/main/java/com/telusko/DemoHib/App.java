package com.telusko.DemoHib;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
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

// 1)
		
//		NativeQuery<Student> query = session.createNativeQuery("select * from student where marks > :marks", Student.class);
//		query.setParameter("marks", 60);
//        query.addEntity(Student.class);
//		// Get list of Student entities matching condition
//		List<Student> students = query.getResultList();
//
//		for (Student s : students) {
//		    System.out.println(s); 
//		}
//		
		
//2)  
		//Native Queries..
		NativeQuery query = session.createNativeQuery("select name,marks from student where marks > :marks");
		query.setParameter("marks", 60);

		query.setTupleTransformer((tuple, aliases) -> {
		    Map<String, Object> map = new HashMap<>();
		    for (int i = 0; i < aliases.length; i++) {
		        map.put(aliases[i], tuple[i]);
		    }
		    return map;
		});

		List results = query.getResultList();

		for (Object o : results) {
		    Map m = (Map) o;
		    System.out.println(m.get("name") + " : " + m.get("marks"));
		}


		
		session.getTransaction().commit();
		session.close();

	}
}
