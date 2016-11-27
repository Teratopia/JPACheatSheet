package client;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Staff;

public class JPQLClient {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		EntityManager em = emf.createEntityManager();
		
//		String q = "SELECT s FROM Staff s where s.id < 10";
//		List<Staff> staffs = em.createQuery(q, Staff.class).getResultList();
//		for (Staff staff : staffs){
//			System.out.println(staff.getLastName());
//		}
//
//		String q1 = "SELECT s.lastName FROM Staff AS s where s.id < 10";
//		List<String> lNames = em.createQuery(q1, String.class).getResultList();
//		for (String lName : lNames){
//			System.out.println(lName);
//		}
//		
//		String q2 = "SELECT s.id, s.lastName FROM Staff AS s where s.id < 10";
//		List<Object[]> lNames = em.createQuery(q2, Object[].class).getResultList();
//		for (Object[] lName : lNames){
//			System.out.println(lName[0]+" "+lName[1]);
//		}
//		---
//		String q3 = "SELECT s.id, s.lastName, s.address.city FROM Staff AS s where s.id < ?1";
//		List<Object[]> lNames = em.createQuery(q3, Object[].class)
//				.setParameter(1,  14).getResultList();
//		for (Object[] lName : lNames){
//			System.out.println(lName[0]+" "+lName[1]+" lives in "+lName[2]);
//		}
//		
//		String q4 = "SELECT s.id, s.lastName, s.address.city FROM Staff AS s where s.id BETWEEN ?1 AND ?2";
//		List<Object[]> lNames = em.createQuery(q4, Object[].class)
//				.setParameter(1,  100).setParameter(2, 110).getResultList();
//		for (Object[] lName : lNames){
//			System.out.println(lName[0]+" "+lName[1]+lName[2]);
//		}
//		
//		String q5 = "SELECT s.firstName, s.lastName, s.email FROM Staff AS s where s.id BETWEEN ?1 AND ?2";
//		List<Object[]> lNames2 = em.createQuery(q5, Object[].class)
//				.setParameter(1,  100).setParameter(2, 110).getResultList();
//		for (Object[] lName : lNames2){
//			System.out.println(lName[0]+" "+lName[1]+" lives in "+lName[2]);
//		}
//		
//		String q6 = "SELECT s.firstName, s.lastName, s.email, a.city FROM Staff s "
//				+ "join s.address a where s.id BETWEEN ?1 AND ?2";
//		List<Object[]> lNames3 = em.createQuery(q6, Object[].class)
//				.setParameter(1,  100).setParameter(2, 110).getResultList();
//		for (Object[] lName : lNames3){
//			System.out.println(lName[0]+" "+lName[1]+" lives in "+lName[3]+" "+lName[2]);
//		}
//		
//		String q7 = "SELECT c.firstName, c.lastName, a.city FROM Customer c "
//				+ "join c.store s join s.address a where s.id = ?1";
//		List<Object[]> lNames3 = em.createQuery(q7, Object[].class)
//				.setParameter(1,  1).getResultList();
//		for (Object[] lName : lNames3){
//			System.out.println(lName[0]+" "+lName[1]+", "+lName[2]);
//		}
		
		String q8 = "SELECT r.id, r.returnDate, r.rentalDate FROM Rental r join r.customer c where c.id = ?1";
		List<Object[]> lNames3 = em.createQuery(q8, Object[].class)
				.setParameter(1,  1).getResultList();
		for (Object[] lName : lNames3){
			System.out.println(lName[0]+", "+lName[1]+", "+lName[2]);
		}
		
		em.close();
		emf.close();
		
	}
}
