package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Actor;

public class DeleteActor {
	
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("VideoStore").createEntityManager();
		Actor a = em.find(Actor.class, 200);
		System.out.println(a);
		em.remove(a);
		System.out.println(a);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		System.out.println(a);
		
		a = null;
		
		System.out.println(a);
	}

}
