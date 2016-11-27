package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	@JoinColumn(name="address_id")
	private Address address;
	@OneToMany(mappedBy = "store")
	private List<Customer> customers;
	@OneToMany(mappedBy = "store")
	private List<Staff> staffs;
	@OneToOne
	@JoinColumn(name="manager_id")
	private Staff manager;
	@ManyToMany
	@JoinTable(name="inventory_item",
		joinColumns=@JoinColumn(name="store_id"),
		inverseJoinColumns=@JoinColumn(name="film_id"))
	List<Film> films;
	@OneToMany(mappedBy = "store")
	private List<InventoryItem> inventoryItems;
	
	public Store(){}
	
	public void addInventoryItem(InventoryItem inv){
		if(inventoryItems == null){
			inventoryItems = new ArrayList<>();
		}
		if(!inventoryItems.contains(inv)){
			inventoryItems.add(inv);
			if(inv.getStore() !=null){
				this.inventoryItems.remove(inv);
			}
			inv.setStore(this);
		}
	}
	
	public void removeInventoryItem(InventoryItem inv){
		if(inventoryItems != null){
			inventoryItems.add(inv);
		}
		
	}
	
	public void addFilm(Film film) {
		if (films == null) {
			films = new ArrayList<>();
		}
		if (!films.contains(film)) {
			films.add(film);
			if (film.getStores() != null) {
				this.films.remove(film);
			}
			film.addStore(this);
		}
	}
	
	public void removeFilm(Film film) {
		if (films != null) {
			films.remove(film);
			System.out.println("test");
			System.out.println(films.contains(film));
			for (Film f : films) {
				if(f.equals(film)){
					System.out.println(f);
				}
			}
		}
	}
	public void addCustomer(Customer customer) {
		if (customers == null) {
			customers = new ArrayList<>();
		}
		if (!customers.contains(customer)) {
			customers.add(customer);
			if (customer.getStore() != null) {
				this.customers.remove(customer);
			}
			customer.setStore(this);
		}
	}

	public void removeCustomer(Customer customer) {
		if (customers != null) {
			customers.remove(customer);
		}
	}
	public void addStaff(Staff staff) {
		if (staffs == null) {
			staffs = new ArrayList<>();
		}
		if (!staffs.contains(staff)) {
			staffs.add(staff);
			if (staff.getStore() != null) {
				this.customers.remove(staff);
			}
			staff.setStore(this);
		}
	}
	
	public void removeStaff(Staff staff) {
		if (staffs != null) {
			staffs.remove(staff);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<Staff> staff) {
		this.staffs = staff;
	}

	public Staff getManager() {
		return manager;
	}

	public void setManager(Staff manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", address=" + address + ", customers=" + customers + ", staffs=" + staffs
				+ ", manager=" + manager + "]";
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	public List<InventoryItem> getInventoryItems() {
		return inventoryItems;
	}

	public void setInventoryItems(List<InventoryItem> inventoryItems) {
		this.inventoryItems = inventoryItems;
	}

}
