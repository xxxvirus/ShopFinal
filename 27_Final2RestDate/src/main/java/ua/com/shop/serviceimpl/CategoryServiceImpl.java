package ua.com.shop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.CategoryDao;
import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Category;
import ua.com.shop.service.CategoryService;
import ua.com.shop.specification.CategorySpecification;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	
	public Category save(Category category) {
		return categoryDao.saveAndFlush(category);
	}

	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	public Category findOne(int id) {
		return categoryDao.findOne(id);
	}

	public void delete(int id) {
		categoryDao.delete(id);
	}

	public void update(Category category) {
		categoryDao.save(category);
	}

//	@Override
//	public Category selectCategory(String categoryName) {
//		return categoryDao.selectCategory(categoryName);
//	}

	@Override
	public Category findByName(String name) {
		return categoryDao.findByName(name);
	}

	@Override
	public Page<Category> findAll(Pageable pageable, SimpleFilter filter) {
		return categoryDao.findAll(new CategorySpecification(filter), pageable);
	}

}
