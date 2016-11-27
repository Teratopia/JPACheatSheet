package client;

import javax.persistence.*;
import entities.Address;

public class AddressClient {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		EntityManager em = emf.createEntityManager();
		Address a = em.find(Address.class, 5);
		System.out.println(a.getAddress()+" , "+a.getCity()+" , "+a.getStateProvince());
		//System.out.println(a);
		em.close();
		emf.close();
	}

}
