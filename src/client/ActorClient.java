package client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Film;

public class ActorClient {
	
//	String q1 = "SELECT s.lastName FROM Staff AS s where s.id < 10";
//	List<String> lNames = em.createQuery(q1, String.class).getResultList();
//	for (String lName : lNames){
//		System.out.println(lName);
//	}
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		EntityManager em = emf.createEntityManager();
		
//		String q8 = "select f from Actor a join a.films f where a.id = 1";
//		List<Film> films = em.createQuery(q8, Film.class).getResultList();
//		int count = 0;
//		for (Film film : films){
//			System.out.println(film.getTitle());
//			count++;
//		}
//		System.out.println(count);
		
		String q9 = "select f from Category c join c.films f where c.name = 'Horror' OR c.name = 'Family'";
		List<Film> films = em.createQuery(q9, Film.class).getResultList();
		int count = 0;
		for (Film film : films){
			System.out.println(film.getTitle());
			count++;
		}
		System.out.println(count);
		
		
		em.close();
		emf.close();
	}

}
