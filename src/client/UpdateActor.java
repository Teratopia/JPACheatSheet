package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Actor;

public class UpdateActor {
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("VideoStore").createEntityManager();
		Actor a = em.find(Actor.class, 199);
		System.out.println(a);
		a.setLastName("Stallone");
		System.out.println(a);
		em.getTransaction().begin();
		em.getTransaction().commit();
				
	}

}
