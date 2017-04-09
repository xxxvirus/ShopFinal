package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(indexes = { @Index(columnList = "namePub") })
public class TitleShop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String namePub;

	@ManyToOne
	private Book book;
	@OneToMany(mappedBy = "titleSh")
	private List<Shop> shops;

	public TitleShop() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNamePub() {
		return namePub;
	}

	public void setNamePub(String namePub) {
		this.namePub = namePub;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Shop> getShops() {
		return shops;
	}

	public void setShops(List<Shop> shops) {
		this.shops = shops;
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
		TitleShop other = (TitleShop) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
