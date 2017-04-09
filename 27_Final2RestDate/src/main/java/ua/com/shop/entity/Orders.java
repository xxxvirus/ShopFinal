package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private boolean send;
	// @Temporal(TemporalType.TIMESTAMP)
	// private Date date;

	@ManyToOne
	private User user;
	@ManyToMany
	@JoinTable(name = "shop_orders", joinColumns = @JoinColumn(name = "id_orders"), inverseJoinColumns = @JoinColumn(name = "id_shop"))
	private List<Shop> shops;

	public Orders() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// public Boolean getSend() {
	// return send;
	// }
	//
	// public void setSend(Boolean send) {
	// this.send = send;
	// }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// public Date getDate() {
	// return date;
	// }
	//
	// public void setDate(Date date) {
	// this.date = date;
	// }

	public boolean getSend() {
		return send;
	}

	public void setSend(boolean send) {
		this.send = send;
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
		Orders other = (Orders) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
