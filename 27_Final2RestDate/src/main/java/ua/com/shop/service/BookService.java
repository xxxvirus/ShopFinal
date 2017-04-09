package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.dto.form.BookForm;
import ua.com.shop.entity.Author;
import ua.com.shop.entity.Book;

public interface BookService {

	void save(BookForm book);
	List<Book> findAll();
	Book findOne(int id);
	void delete(int id);
	void update(Book book);
//	public Book fetchAuthorBooks(String name);
//	void addAuthorToBook(String bookName, Integer pages, String authorName, String authorSurname);
//	void createAuthorBook(String title, Integer pages, String authorName, String authorSurname);
	void delAuthorFromBook(String authorName, String authorSurname);
	List<Book> findByAuthorId(int id);
	
	BookForm findForm(int id);
	Book findUnique(String title, String firstpub, Author author);
	Page<Book> findAll(Pageable pageable, SimpleFilter filter);
	
}
