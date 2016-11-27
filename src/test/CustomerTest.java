package test;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Address;
import entities.Customer;
import entities.Film;
import entities.Language;
import entities.Rental;
import entities.Staff;
import entities.Store;

public class CustomerTest {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	
	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("VideoStore");
		em = emf.createEntityManager();
	}
	
	@Test
	public void testCustomer() throws ParseException {
		Customer cust = em.find(Customer.class, 1);
		assertEquals("Mary", cust.getFirstName());
		assertEquals("Smithers", cust.getLastName());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date expected = formatter.parse("2014-05-25");
		assertEquals(expected, cust.getCreateDate());
		Address a = cust.getAddress();
		assertEquals("Sasebo", a.getCity());
		assertEquals(573, cust.getRentals().get(1).getId());
		assertEquals(95, cust.getRentals().size());
	}
	@Test
	public void testLanguage() throws ParseException {
		Language l = em.find(Language.class, 1);
		assertEquals("English", l.getName());
	}
	@Test
	public void testStaff() throws ParseException {
		Staff s = em.find(Staff.class, 1);
		assertEquals("Larry", s.getFirstName());
		assertEquals("Kong", s.getLastName());
		assertEquals("Las Vegas", s.getAddress().getCity());
	}
	@Test
	public void testFilm() throws ParseException {
		Film f = em.find(Film.class, 1);
		assertEquals("ACADEMY DINOSAUR", f.getTitle());
		assertEquals("Japanese", f.getLanguage().getName());
		List<Film> films = f.getLanguage().getFilms();
		assertEquals(9, films.size());
	}
	@Test
	public void testAddress() throws ParseException {
		Address a = em.find(Address.class, 1);
		assertEquals("Lethbridge", a.getCity());
	}
	@Test
	public void testRental() throws ParseException {
		Rental r = em.find(Rental.class, 1);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date expected = formatter.parse("2014-05-24");
		assertEquals(expected, r.getRentalDate());
		assertEquals("William", r.getStaff().getFirstName());
	}
	@Test
	public void testStore() throws ParseException {
		Store s = em.find(Store.class, 2);
		assertEquals("Denver", s.getAddress().getCity());
		assertEquals("242 North Milwaukee St", s.getAddress().getAddress());
		assertEquals("Lisa", s.getManager().getFirstName());
	}
	@Test
	public void testCountry() throws ParseException {
		Store s = em.find(Store.class, 1);
		assertEquals("Seattle", s.getAddress().getCity());
		assertEquals("264 Blanchard Ave", s.getAddress().getAddress());
		assertEquals("United States", s.getAddress().getCountry().getName());
	}
	
	@After
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}
}
