package client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import entities.Film;

public class MarkUpClient {
	private static EntityManager em;

	
	public static void main(String[] args) {
		em = Persistence.createEntityManagerFactory("VideoStore").createEntityManager();
		
		String q10 = "Select i.film from InventoryItem i where i.film.rentalRate < 1.0";
		
		List<Film> lNames3 = em.createQuery(q10, Film.class)
				.getResultList();
		int count = 0;
		for (Film lName : lNames3){
			System.out.println(lName.getRentalRate());
			count++;
		}
		System.out.println(count);
		System.out.println("---------");
		count = 0;
		for (Film lName : lNames3){
			lName.setRentalRate(1.49);
			count++;
		}
		System.out.println(count);
		System.out.println("---------");
		count = 0;
		for (Film lName : lNames3){
			System.out.println(lName.getRentalRate());
			count++;
		}
		System.out.println(count);
		System.out.println("---------");
		count = 0;
		
		em.close();
		
	}

}
