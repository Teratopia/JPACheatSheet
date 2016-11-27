package client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import entities.Customer;
import entities.Film;

public class EmailClient {
	private static EntityManager em;

	
	public static void main(String[] args) {
		em = Persistence.createEntityManagerFactory("VideoStore").createEntityManager();
		
		String q10 = "Select c from Customer c where c.email = null OR c.email = ''";
		
		List<Customer> lNames3 = em.createQuery(q10, Customer.class)
				.getResultList();
		int count = 0;
		for (Customer lName : lNames3){
			System.out.println(lName.getFirstName()+" "+lName.getEmail());
			count++;
		}
		System.out.println(count);
		System.out.println("---------");
		count = 0;
		for (Customer lName : lNames3){
			lName.setEmail(lName.getFirstName()+"."+lName.getLastName()+"@sdvidcustomer.org");
			count++;
		}
		System.out.println(count);
		System.out.println("---------");
		count = 0;
		for (Customer lName : lNames3){
			System.out.println(lName.getFirstName()+" "+lName.getEmail());
			count++;
		}
		System.out.println(count);
		System.out.println("---------");
		count = 0;
		
	}
}
