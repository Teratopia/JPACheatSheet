package client;
import javax.persistence.*;
import entities.Customer;

public class CustomerClient {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		EntityManager em = emf.createEntityManager();
		Customer c = em.find(Customer.class, 45);
		System.out.println(c);
		
		em.close();
		emf.close();
	}
}