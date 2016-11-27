package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Film;
import entities.Language;
import entities.Staff;

public class LotsaClient {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		EntityManager em = emf.createEntityManager();
		
		Staff s = em.find(Staff.class, 5);
		System.out.println(s.getFirstName()+" "+s.getLastName());
		
		Film f = em.find(Film.class, 12);
		System.out.println(f.getTitle()+": "+f.getDescription());
		
		Language l = em.find(Language.class, 3);
		System.out.println(l);
		//System.out.println(a);
		em.close();
		emf.close();
	}
}