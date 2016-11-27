package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Film;
import entities.InventoryItem;
import entities.MediaCondition;
import entities.Payment;
import entities.Store;

public class CatTest {
	private EntityManagerFactory emf;
	private EntityManager em;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("VideoStore");
		em = emf.createEntityManager();
	}

//	@Test
//	public void test1() {
//		Category c = em.find(Category.class, 6);
//		assertEquals("Documentary", c.getName());
//		assertEquals(68, c.getFilms().size());
//		Film f = em.find(Film.class, 3);
//		c.removeFilm(f);
//		f.removeCategory(c);
//		assertEquals(67, c.getFilms().size());
//		assertEquals(0, f.getCategories().size());
//		
//	}
//
//	@Test
//	public void test2() {
//		Store s = em.find(Store.class, 1);
//		Film f = em.find(Film.class, 7);
//		
////		assertEquals(true, s.getFilms().contains(f));
//		
//		s.removeFilm(f);
//		s.removeFilm(f);
//		f.removeStore(s);
//		
//		assertEquals(true, s.getFilms().contains(f));
//		
//	}
//	@Test
//	public void test3() {
//		Store s = em.find(Store.class, 1);
//		Film f = em.find(Film.class, 7);
//		
////		assertEquals(true, s.getFilms().contains(f));
//		s.addFilm(f);
//		int count = 0;
//		for(Film film : s.getFilms()){
//			
//			if(film.equals(f)){
//				count++;
//			}
//		}
//		assertEquals(3, count);
//	}

//	@Test
//	public void test4() {
////		Store s = em.find(Store.class, 1);
////		Film f = em.find(Film.class, 7);
//		InventoryItem i = em.find(InventoryItem.class, 1);
////		assertEquals(true, s.getFilms().contains(f));
////		s.addFilm(f);
////		int count = 0;
////		for(Film film : s.getFilms()){
////			
////			if(film.equals(f)){
////				count++;
////			}
////		}
////		assertEquals(3, count);
//		
//		assertEquals(1, i.getStore().getId());
//		assertEquals(MediaCondition.Used, i.getMediaCondition());
//		assertEquals(1, i.getFilm().getId());
//		
//	}
//	@Test
//	public void testInventoryToRental() {
//
//		InventoryItem i = em.find(InventoryItem.class, 1);
//		assertEquals(3, i.getRentals().size());
//		
//	}
	@Test
	public void testPayment() {
		
		Payment p = em.find(Payment.class, 1);
		assertEquals(107, p.getRentalId());
		
	}
	
	@After
	public void tearDown() throws Exception {
		
		em.close();
		emf.close();
		
	}
}
