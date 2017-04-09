package ua.com.shop.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	private TitleShop titleSh;

	@ManyToOne
	private SeriaPub shSeria;

	@ManyToOne
	private Languages shlang;

	@ManyToOne
	private Category shcat;

	private int shyear;
	private BigDecimal shprice;
	private String isbn;
	private int edition;
	private int shpage;
	@Lob
	private String anotation;

	private int version;
	@Transient
	private MultipartFile file;

	@ManyToMany
	@JoinTable(name = "shop_orders", joinColumns = @JoinColumn(name = "id_shop"), inverseJoinColumns = @JoinColumn(name = "id_orders"))
	private List<Orders> orders;

	public Shop() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TitleShop getTitleSh() {
		return titleSh;
	}

	public void setTitleSh(TitleShop titleSh) {
		this.titleSh = titleSh;
	}

	public SeriaPub getShSeria() {
		return shSeria;
	}

	public void setShSeria(SeriaPub shSeria) {
		this.shSeria = shSeria;
	}

	public Languages getShlang() {
		return shlang;
	}

	public void setShlang(Languages shlang) {
		this.shlang = shlang;
	}

	public Category getShcat() {
		return shcat;
	}

	public void setShcat(Category shcat) {
		this.shcat = shcat;
	}

	public int getShyear() {
		return shyear;
	}

	public void setShyear(int shyear) {
		this.shyear = shyear;
	}

	public BigDecimal getShprice() {
		return shprice;
	}

	public void setShprice(BigDecimal shprice) {
		this.shprice = shprice;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public int getShpage() {
		return shpage;
	}

	public void setShpage(int shpage) {
		this.shpage = shpage;
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

	public String getAnotation() {
		return anotation;
	}

	public void setAnotation(String anotation) {
		this.anotation = anotation;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
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
		Shop other = (Shop) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
