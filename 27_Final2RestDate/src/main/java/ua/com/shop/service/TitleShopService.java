package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.TitleShop;

public interface TitleShopService {

	void save(TitleShop titleSh);
	List<TitleShop> findAll();
	TitleShop findOne(int id);
	void delete(int id);
	void update(TitleShop titleSh);
	
	TitleShop findByUnique(String namePub, int bookId);
	
	List<TitleShop> findByAuthorId(int id);
	Page<TitleShop> findAll(Pageable pageable, SimpleFilter filter);
}
