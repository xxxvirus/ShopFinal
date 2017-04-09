package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Category;

public interface CategoryService {

	Category save(Category category);
	List<Category> findAll();
	Category findOne(int id);
	void delete(int id);
	void update(Category category);
//	Category selectCategory(String categoryName);
	Category findByName(String name);
	Page<Category> findAll(Pageable pageable, SimpleFilter filter);
}
