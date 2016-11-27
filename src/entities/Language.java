package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(mappedBy = "language")
	private List<Film> films;

	public Language() {
	}

	public int getId() {
		return id;
	}

	public void addFilm(Film film) {
		if (films == null) {
			films = new ArrayList<>();
		}
		if (!films.contains(film)) {
			films.add(film);
			if (film.getLanguage() != null) {
				film.getLanguage().getFilms().remove(film);
			}
			film.setLanguage(this);
		}
	}

	public void removeFilm(Film film) {
		film.setLanguage(null);
		if (films != null) {
			films.remove(film);
		}
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
		return "Language [id=" + id + ", name=" + name + "]";
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

}
