package ua.com.shop.dto.form;

import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

public class AuthorForm {

	private int id;
	private String name;
	private String surname;
	private String yearOfBorn;
	private String yearOfDead;
	private String wiki;
	private String biography;
	private int version;
	@Transient
	private MultipartFile file;

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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getYearOfBorn() {
		return yearOfBorn;
	}

	public void setYearOfBorn(String yearOfBorn) {
		this.yearOfBorn = yearOfBorn;
	}

	public String getYearOfDead() {
		return yearOfDead;
	}

	public void setYearOfDead(String yearOfDead) {
		this.yearOfDead = yearOfDead;
	}

	public String getWiki() {
		return wiki;
	}

	public void setWiki(String wiki) {
		this.wiki = wiki;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
