package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Genre;

public interface GenreService {

	void save(Genre genre);
	List<Genre> findAll();
	Genre findOne(int id);
	void delete(int id);
	void update(Genre genre);
	
	void addBook(int id, int bookId);
	Genre loadBooks(int id);
	void deleteBook(int id, int bookId);
	List<Genre> findAll(List<Integer> collect);
	Genre findByName(String nameOfG);
	Page<Genre> findAll(Pageable pageable, SimpleFilter filter);
}
