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
	
	@NamedQuery(name = "FindByLnag", query = "select l from Languages l where l.lang=:name"),
	
})

@Entity
public class Languages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String lang;
	
	@OneToMany(mappedBy="shlang")
	@JsonIgnore
	private List<Shop> shop= new ArrayList<>();

	public Languages() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
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
		Languages other = (Languages) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
