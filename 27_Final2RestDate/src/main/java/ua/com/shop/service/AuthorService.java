package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.dto.form.AuthorForm;
import ua.com.shop.entity.Author;

public interface AuthorService {

	void save(AuthorForm author);
	List<Author> findAll();
	void delete(int id);
	void update(Author author);
	Author selectAuthor(String authorName, String authorSurname);
	void showAuthorBooks(String authorName, String authorSurname);
	Author fetchAuthor(String authorName, String authorSurname);
	
	AuthorForm findForm(int id);
	Author findUnique(String name, String surname, String yearOfBorn, String yearOfDead, String wiki);
	Author findOne(int id);
	
	Page<Author> findAll(Pageable pageable, SimpleFilter filter);
}
