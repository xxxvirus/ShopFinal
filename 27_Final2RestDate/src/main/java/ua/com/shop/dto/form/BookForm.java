package ua.com.shop.dto.form;

import java.util.List;

import ua.com.shop.entity.Author;
import ua.com.shop.entity.Genre;

public class BookForm {

	private int id;
	private String title;
	private String firstpub;
	private Author author;
	private List<Genre> genre;

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

	public String getFirstpub() {
		return firstpub;
	}

	public void setFirstpub(String firstpub) {
		this.firstpub = firstpub;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Genre> getGenre() {
		return genre;
	}

	public void setGenre(List<Genre> genre) {
		this.genre = genre;
	}

}
