package client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.InventoryItem;

public class InventoryItemClient {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	public static void main(String[] args) {
		emf = Persistence.createEntityManagerFactory("VideoStore");
		em = emf.createEntityManager();
		
//		InventoryItem i = em.find(InventoryItem.class, 1);
//
//		String q8 = "SELECT i.film.title, i.mediaCondition from InventoryItem i where i.film.title like 'A%' AND "
//				+ "i.store.id = 1";
//		List<Object[]> lNames3 = em.createQuery(q8, Object[].class)
//				.getResultList();
//		int count = 0;
//		for (Object[] lName : lNames3){
//			System.out.println(lName[0]+", "+lName[1]);
//			count++;
//		}
//		System.out.println(count);
//		
//		String q9 = "SELECT r.inventoryItem.film.title, r.rentalDate, p.amount from Rental r join r.payments p "
//				+ "where r.customer.id = 1 AND p.rentalId = r.id";
//		
//		List<Object[]> lNames3 = em.createQuery(q9, Object[].class)
//				.getResultList();
//		int count = 0;
//		for (Object[] lName : lNames3){
//			System.out.println(lName[0]+", "+lName[1]+", "+lName[2]);
//			count++;
//		}
//		System.out.println(count);
//		
//		em.close();
//		emf.close();
//	}
	
	String q10 = "SELECT s.firstName, s.lastName from Staff s where s.supervisor.firstName = 'Jeff' AND s.supervisor.lastName='Tirpak'";
	
	List<Object[]> lNames3 = em.createQuery(q10, Object[].class)
			.getResultList();
	int count = 0;
	for (Object[] lName : lNames3){
		System.out.println(lName[0]+" "+lName[1]);
		count++;
	}
	System.out.println(count);
	
	em.close();
	emf.close();
}
	
//	6. Create a program that lists the name and rental date for each Film
//	rented by Customer #1. You should get 95 results.
	
}
