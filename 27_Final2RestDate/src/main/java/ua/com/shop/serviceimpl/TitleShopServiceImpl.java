package ua.com.shop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.TitleShopDao;
import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.TitleShop;
import ua.com.shop.service.TitleShopService;
import ua.com.shop.specification.TitleShopSpecification;

@Service
public class TitleShopServiceImpl implements TitleShopService{

	@Autowired
	private TitleShopDao titleShopDao;
	@Override
	public void save(TitleShop titleSh) {
		titleShopDao.save(titleSh);
	}

	@Override
	public List<TitleShop> findAll() {
		return titleShopDao.findAll();
	}

	@Override
	public TitleShop findOne(int id) {
		return titleShopDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		titleShopDao.delete(id);
	}

	@Override
	public void update(TitleShop titleSh) {
		titleShopDao.save(titleSh);
	}

	@Override
	public TitleShop findByUnique(String namePub, int bookId) {
		return titleShopDao.findByUnique(namePub, bookId);
	}

	@Override
	public List<TitleShop> findByAuthorId(int id) {
		return titleShopDao.findByAuthorId(id);
	}

	@Override
	public Page<TitleShop> findAll(Pageable pageable, SimpleFilter filter) {
		return titleShopDao.findAll(new TitleShopSpecification(filter), pageable);
	}

}
