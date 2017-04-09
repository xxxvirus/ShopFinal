package ua.com.shop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.AuthorDao;
import ua.com.shop.dao.BookDao;
import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.dto.form.BookForm;
import ua.com.shop.entity.Author;
import ua.com.shop.entity.Book;
import ua.com.shop.service.BookService;
import ua.com.shop.specification.BookSpecification;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Autowired
	private AuthorDao authorDao;

	public void save(Book book) {
		bookDao.save(book);
	}

	public List<Book> findAll() {
		return bookDao.findAll();
	}

	public Book findOne(int id) {
		return bookDao.findOne(id);
	}

	public void delete(int id) {
		bookDao.delete(id);
	}

	public void update(Book book) {
		bookDao.save(book);
	}

	public void delAuthorFromBook(String authorName, String authorSurname) {
		Book book = bookDao.authorS(authorName, authorSurname);
		book.setAuthor(null);
		bookDao.save(book);
	}

	public Book authorS(String authorName, String authorSurname) {
		return bookDao.authorS(authorName, authorSurname);
	}


	// public void createAuthorBook(String title, Integer pages, String
	// authorName, String authorSurname){
	// Book book = bookDao.selectBook(title, pages);
	// Author author = authorDao.selectAuthor(authorName, authorSurname);
	// if (book == null) {
	// Book book2 = new Book(title, pages);
	// bookDao.save(book2);
	// }
	// if (author != null) {
	// Book book2 = bookDao.selectBook(title, pages);
	// book2.setAuthor(author);
	// bookDao.save(book2);
	// } else {
	// Author author2 = new Author(authorName, authorSurname);
	// authorDao.save(author2);
	// Book book3 = bookDao.selectBook(title, pages);
	// book3.setAuthor(author2);
	// bookDao.save(book3);
	// }
	// }

	@Override
	public List<Book> findByAuthorId(int id) {
		return bookDao.findByAuthorId(id);
	}

	@Override
	public void save(BookForm form) {
		Book book = new Book();
		book.setId(form.getId());
		book.setTitle(form.getTitle());
		book.setFirstpub(Integer.valueOf(form.getFirstpub()));
		book.setAuthor(form.getAuthor());
		book.setGenre(form.getGenre());
		bookDao.save(book);
	}

	@Override
	public BookForm findForm(int id) {
		BookForm form = new BookForm();
		Book book = bookDao.findOne(id);
		form.setId(book.getId());
		form.setTitle(book.getTitle());
		form.setFirstpub(String.valueOf(book.getFirstpub()));
		form.setAuthor(book.getAuthor());
		form.setGenre(book.getGenre());
		return form;
	}

	@Override
	public Book findUnique(String title, String firstpub,
			Author author) {
		return bookDao.findUnique(title, 
				Integer.valueOf(firstpub), author.getId());
	}

	@Override
	public Page<Book> findAll(Pageable pageable, SimpleFilter filter) {
		return bookDao.findAll(new BookSpecification(filter), pageable);
	}

//	@Override
//	public Page<Book> findAll(Pageable pageable, BookFilter filter) {
//		return bookDao.findAll(new BookSpecification(filter), pageable);
//	}

}
