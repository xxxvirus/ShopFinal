package ua.com.shop.dto.form;

import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.entity.Category;
import ua.com.shop.entity.Languages;
import ua.com.shop.entity.SeriaPub;
import ua.com.shop.entity.TitleShop;

public class ShopForm {

	private int id;
	private TitleShop titleSh;
	private SeriaPub shSeria;
	private Languages shlang;
	private Category shcat;

	private String shyear;
	private String shprice;
	private String isbn;
	private String edition;
	private String shpage;
	private String anotation;
	private int version;
	@Transient
	private MultipartFile file;

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

	public String getShyear() {
		return shyear;
	}

	public void setShyear(String shyear) {
		this.shyear = shyear;
	}

	public String getShprice() {
		return shprice;
	}

	public void setShprice(String shprice) {
		this.shprice = shprice;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getShpage() {
		return shpage;
	}

	public void setShpage(String shpage) {
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
	
}
