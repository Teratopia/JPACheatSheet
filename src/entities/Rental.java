package entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Rental {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "rental_date")
	@Temporal(TemporalType.DATE)
	private Date rentalDate;
	@Column(name = "return_date")
	@Temporal(TemporalType.DATE)
	private Date returnDate;
	@ManyToOne
	@JoinColumn(name = "staff_id")
	private Staff staff;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@OneToMany
	@JoinColumn(name="rental_id", referencedColumnName="id")
	private List<Payment> payments;
	@ManyToOne
	@JoinColumn(name = "inventory_id")
	private InventoryItem inventoryItem;
	
	
	public Rental(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "Rental [id=" + id + ", rentalDate=" + rentalDate + ", returnDate=" + returnDate + "]";
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public InventoryItem getInventoryItem() {
		return inventoryItem;
	}

	public void setInventoryItem(InventoryItem inventoryItem) {
		this.inventoryItem = inventoryItem;
	}
	
	

}
