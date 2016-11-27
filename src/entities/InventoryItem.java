package entities;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="inventory_item")
public class InventoryItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="media_condition")
	@Enumerated(EnumType.STRING)
	private MediaCondition mediaCondition;
	@ManyToOne
	@JoinColumn(name="film_id")
	private Film film;
	@ManyToOne
	@JoinColumn(name="store_id")
	private Store store;
	@OneToMany(mappedBy = "inventoryItem")
	private List<Rental> rentals;
	
	public InventoryItem(){}

	public int getId() {
		return id;
	}

	public MediaCondition getMediaCondition() {
		return mediaCondition;
	}

	public void setMediaCondition(MediaCondition mediaCondition) {
		this.mediaCondition = mediaCondition;
	}

	@Override
	public String toString() {
		return "InventoryItem [id=" + id + ", mediaCondition=" + mediaCondition + "]";
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}
	
}
