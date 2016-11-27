package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	@Column(name = "release_year")
	private int releaseYear;
	private int length;
	@Column(name = "rental_rate")
	private double rentalRate;
	@Column(name = "replacement_cost")
	private double replacementCost;
	@Enumerated(EnumType.STRING)
	private Rating rating;
	@ManyToOne
	@JoinColumn(name = "language_id")
	private Language language;
	@ManyToMany(mappedBy = "films")
	private List<Actor> actors;
	@ManyToMany(mappedBy = "films")
	private List<Category> categories;
	@ManyToMany(mappedBy = "films")
	private List<Store> stores;
	@OneToMany(mappedBy = "film")
	private List<InventoryItem> inventoryItems;

	
	public Film() {
	}

	public void addCategory(Category category) {
		if (categories == null) {
			categories = new ArrayList<>();
		}
		if (!categories.contains(category)) {
			categories.add(category);
			category.addFilm(this);
		}
	}
	public void removeCategory(Category category) {
		if (stores != null && stores.contains(category)) {
			stores.remove(category);
			category.addFilm(this);
		}
	}
	public void addStore(Store store) {
		if (stores == null) {
			stores = new ArrayList<>();
		}
		if (!stores.contains(store)) {
			stores.add(store);
			store.addFilm(this);
		}
	}
	
	public void removeStore(Store store) {
		if (categories != null && categories.contains(store)) {
			categories.remove(store);
			store.addFilm(this);
		}
	}
	
	public void addActor(Actor actor) {
		if (actors == null) {
			actors = new ArrayList<>();
		}
		if (!actors.contains(actor)) {
			actors.add(actor);
			actor.addFilm(this);
		}
	}
	public void removeActor(Actor actor) {
		if (actors != null && actors.contains(actor)) {
			actors.remove(actor);
			actor.removeFilm(this);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", description=" + description + ", releaseYear=" + releaseYear
				+ ", length=" + length + ", rentalRate=" + rentalRate + ", replacementCost=" + replacementCost + "]";
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

}
