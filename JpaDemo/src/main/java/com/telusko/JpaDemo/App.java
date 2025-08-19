package com.telusko.JpaDemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
//to fetch data    	
    	
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("corpPersistenceUnit");
//        EntityManager em = emf.createEntityManager();
//        
//        Alien a = em.find(Alien.class, 3);
//        System.out.println(a);
//        
//        em.close();
//        emf.close();
    	
  
    	
//to add data    	
    	 Alien a = new Alien();
    	 a.setAid(10);
    	 a.setAname("Lina");
    	 a.setTech("Python"); 
    	
    	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("corpPersistenceUnit");
         EntityManager em = emf.createEntityManager();
         
         em.getTransaction().begin();
         
         em.persist(a);
         em.getTransaction().commit();
         
         System.out.println(a);
         
    }
}
