package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToMany
	@JoinTable(name="film_category",
		joinColumns=@JoinColumn(name="category_id"),
		inverseJoinColumns=@JoinColumn(name="film_id"))
	List<Film> films;
	
	public Category(){}
	
	public void addFilm(Film film) {
		if (films == null) {
			films = new ArrayList<>();
		}
		if (!films.contains(film)) {
			films.add(film);
			film.addCategory(this);
		}
	}

	public void removeFilm(Film film) {
		if (films != null && films.contains(film)) {
			films.remove(film);
			film.removeCategory(this);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}
	
}
