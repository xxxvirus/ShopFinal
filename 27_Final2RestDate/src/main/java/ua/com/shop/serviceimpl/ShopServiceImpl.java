package ua.com.shop.serviceimpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.dao.CategoryDao;
import ua.com.shop.dao.LanguagesDao;
import ua.com.shop.dao.SeriaPubDao;
import ua.com.shop.dao.ShopDao;
import ua.com.shop.dto.filter.ShopFilter;
import ua.com.shop.dto.form.ShopForm;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Languages;
import ua.com.shop.entity.SeriaPub;
import ua.com.shop.entity.Shop;
import ua.com.shop.entity.TitleShop;
import ua.com.shop.service.FileWriter;
import ua.com.shop.service.FileWriter.Folder;
import ua.com.shop.service.ShopService;
import ua.com.shop.specification.ShopSpecification;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao shopDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private LanguagesDao langDao;
	@Autowired
	private SeriaPubDao seriaPubDao;
	@Autowired
	private FileWriter fileWriter;

	public void save(Shop shop) {
//		MultipartFile file = shop.getFile();
//		shop = shopDao.saveAndFlush(shop);
//		if(fileWriter.write(Folder.SHOP, file, shop.getId())){
//			shop.setVersion(shop.getVersion()+1);
			shopDao.save(shop);
//		}
	}

	public List<Shop> findAll() {
		return shopDao.findAll();
	}

	public Shop findOne(int id) {
		return shopDao.findOne(id);
	}

	public void delete(int id) {
		shopDao.delete(id);
	}

	public void update(Shop shop) {
		shopDao.save(shop);
	}

	// @Override
	// public void addEl(int year, BigDecimal price, String bookT, String nameC,
	// String nameL,
	// String nameS) {
	// Shop shop = new Shop(year, price);
	// shopDao.save(shop);
	// int id = shop.getId();
	// Shop shopp = shopDao.selectShop(price, year, id);
	// Book book = bookDao.bookName(bookT);
	// shopp.setShbook(book);
	// Category category = categoryDao.selectCategory(nameC);
	// shopp.setShcat(category);
	// Languages lang = langDao.selectLang(nameL);
	// shopp.setShlang(lang);
	// SeriaPub seria = seriaPubDao.selectSeria(nameS);
	// shopp.setShSeria(seria);
	// shopDao.save(shopp);
	// }

	@Override
	public Shop selectShop(BigDecimal price, int year, int id) {
		return shopDao.selectShop(price, year, id);
	}

	@Override
	public void save(ShopForm form) {
		Shop shop = new Shop();
		shop.setId(form.getId());
		shop.setIsbn(form.getIsbn());
		shop.setEdition(Integer.valueOf(form.getEdition()));
		shop.setShpage(Integer.valueOf(form.getShpage()));
		shop.setShyear(Integer.valueOf(form.getShyear()));
		shop.setShprice(new BigDecimal(form.getShprice()));
		shop.setShcat(form.getShcat());
		shop.setShlang(form.getShlang());
		shop.setShSeria(form.getShSeria());
		shop.setTitleSh(form.getTitleSh());
		shop.setAnotation(form.getAnotation());
		shop.setVersion(form.getVersion());
		MultipartFile file = form.getFile();
		shop = shopDao.saveAndFlush(shop);
		if(fileWriter.write(Folder.SHOP, file, shop.getId())){
			shop.setVersion(shop.getVersion()+1);
			shopDao.save(shop);
		}
	}

	@Override
	public ShopForm findForm(int id) {
		ShopForm form = new ShopForm();
		Shop shop = shopDao.findOne(id);
		form.setId(shop.getId());
		form.setTitleSh(shop.getTitleSh());
		form.setShcat(shop.getShcat());
		form.setShlang(shop.getShlang());
		form.setShSeria(shop.getShSeria());
		form.setIsbn(shop.getIsbn());
		form.setEdition(String.valueOf(shop.getEdition()));
		form.setShpage(String.valueOf(shop.getShpage()));
		form.setShyear(String.valueOf(shop.getShyear()));
		form.setShprice(String.valueOf(shop.getShprice()));
		form.setAnotation(shop.getAnotation());
		form.setVersion(shop.getVersion());
		return form;
	}

	@Override
	public Shop findUnique(String shyear, String shprice, String isbn,
			String edition, String shpage, TitleShop titleShop,
			SeriaPub seriaPub, Languages lang, Category category) {
		return shopDao.findUnique(Integer.valueOf(shyear), new BigDecimal(shprice.replace(',', '.')), isbn, Integer.valueOf(edition), Integer.valueOf(shpage), titleShop.getId(), seriaPub.getId(), lang.getId(), category.getId());
	}

	@Override
	public Page<Shop> findAll(Pageable pageable, ShopFilter filter) {
		return shopDao.findAll(new ShopSpecification(filter), pageable);
	}

//	@Override
//	public Shop loadedGenres(int id) {
//		return shopDao.loadedGenres(id);
//	}
	
//	@Override
//	public Page<Shop> findAll(int id, Pageable pageable, ShopFilter filter) {
//		return shopDao.findAll(new ShopSpecification(filter), pageable);
//	}

//	@Override
//	public Page<Shop> findByAuthor(int id, Pageable pageable, ShopFilter filter) {
//		return shopDao.findByAuthorIdd(id, shopDao.findAll(new ShopSpecification(filter), pageable));
//	}

}
