package ua.com.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@NamedQueries({

@NamedQuery(name = "FindByCat", query = "select c from Category c where c.nameOfC=:name"),

})
@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nameOfC;
	@OneToMany(mappedBy = "shcat")
	@JsonIgnore
	private List<Shop> shop = new ArrayList<>();

	public Category() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameOfC() {
		return nameOfC;
	}

	public void setNameOfC(String nameOfC) {
		this.nameOfC = nameOfC;
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
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
