package client;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Address;
import entities.Country;
import entities.Customer;
import entities.Store;

public class AddCustomer {
	
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("VideoStore").createEntityManager();
		
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//		Country co = em.find(Country.class, "DO");
//		Store st = em.find(Store.class, 1);
//		Date date = new Date();
//		Address a = em.find(Address.class, 1);
//		
//		Customer c = new Customer();
//		c.setFirstName("Andre");
//		c.setLastName("McGobelston");
//		c.setEmail("asdfa");
//		c.setCreateDate(date);
//		c.setStore(st);
//		c.setAddress(a);
//		System.out.println(c);
//		
//		em.persist(c);
//		tx.commit();
//		
//		em.close();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Country co = em.find(Country.class, "DO");
		Store st = em.find(Store.class, 1);
		Date date = new Date();
		
		Address a = new Address();
		
		a.setAddress("asdf");
		a.setAddress2("asdf");
		a.setCity("aaa");
		a.setCountry(co);
		a.setPhone("1231231233");
		a.setPostalCode("12343");
		a.setStateProvince("adfadf");
		
		Customer c = new Customer();
		c.setFirstName("Andre");
		c.setLastName("McGobelston");
		c.setEmail("asdfa");
		c.setCreateDate(date);
		c.setStore(st);
		c.setAddress(a);
		System.out.println(c);
		
		em.persist(c);
		tx.commit();
		
		em.close();
		
	}

}
