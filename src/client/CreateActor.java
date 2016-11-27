package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Actor;

public class CreateActor {
	
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("VideoStore").createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Actor a = new Actor();
		a.setFirstName("Troy");
		a.setLastName("McClure");
		System.out.println(a);
		em.persist(a);
		
		tx.commit();
		
		em.close();
		
		
				
	}

}
