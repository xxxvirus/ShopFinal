package ua.com.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({

@NamedQuery(name = "FindBySeria", query = "select s from SeriaPub s where s.nameOfS=:name"),

})
@Entity
public class SeriaPub {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nameOfS;
	@ManyToOne
	private Publisher publisher;

	@OneToMany(mappedBy = "shSeria")
	private List<Shop> shop = new ArrayList<>();

	public SeriaPub() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameOfS() {
		return nameOfS;
	}

	public void setNameOfS(String nameOfS) {
		this.nameOfS = nameOfS;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<Shop> getShop() {
		return shop;
	}

	public void setShop(List<Shop> shop) {
		this.shop = shop;
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
		SeriaPub other = (SeriaPub) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
