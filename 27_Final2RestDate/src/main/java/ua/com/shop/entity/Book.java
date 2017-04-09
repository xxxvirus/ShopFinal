package ua.com.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(indexes = { @Index(columnList = "title"),
		@Index(columnList = "firstpub") })
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private int firstpub;
	@ManyToOne
	private Author author;

	@ManyToMany
	@JoinTable(name = "book_genre", joinColumns = @JoinColumn(name = "id_book"), inverseJoinColumns = @JoinColumn(name = "id_genre"))
	private List<Genre> genre = new ArrayList<>();

	@OneToMany(mappedBy = "book")
	private List<TitleShop> titleshops;

	public Book() {
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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getFirstpub() {
		return firstpub;
	}

	public void setFirstpub(int firstpub) {
		this.firstpub = firstpub;
	}

	public List<TitleShop> getTitleshops() {
		return titleshops;
	}

	public void setTitleshops(List<TitleShop> titleshops) {
		this.titleshops = titleshops;
	}

	public List<Genre> getGenre() {
		return genre;
	}

	public void setGenre(List<Genre> genre) {
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
