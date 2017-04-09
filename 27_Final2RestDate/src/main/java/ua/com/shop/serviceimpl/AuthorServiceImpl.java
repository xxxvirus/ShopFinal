package ua.com.shop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.dao.AuthorDao;
import ua.com.shop.dao.BookDao;
import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.dto.form.AuthorForm;
import ua.com.shop.entity.Author;
import ua.com.shop.entity.Book;
import ua.com.shop.service.AuthorService;
import ua.com.shop.service.FileWriter;
import ua.com.shop.service.FileWriter.Folder;
import ua.com.shop.specification.AuthorSpecification;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDao authorDao;
	@Autowired
	private BookDao bookDao;
	@Autowired
	private FileWriter fileWriter;
	
	public void save(Author author) {
		authorDao.save(author);
	}

	public List<Author> findAll() {
		return authorDao.findAll();
	}

	public Author findOne(int id) {
		return authorDao.findOne(id);
	}

	public void delete(int id) {
		authorDao.delete(id);
	}

	public void update(Author author) {
		authorDao.save(author);
	}

	public Author selectAuthor(String authorName, String authorSurname) {
		return authorDao.selectAuthor(authorName, authorSurname);
	}

	@Override
	public void showAuthorBooks(String authorName, String authorSurname) {
		Author author = authorDao.fetchAuthor(authorName, authorSurname);
		for (Book book : author.getBooks()) {
			System.out.println(book);
		}
	}

	@Override
	public Author fetchAuthor(String authorName, String authorSurname) {
		return authorDao.fetchAuthor(authorName, authorSurname);
	}

	@Override
	public void save(AuthorForm form) {
		Author author = new Author();
		author.setId(form.getId());
		author.setName(form.getName());
		author.setSurname(form.getSurname());
		author.setYearOfBorn(Integer.valueOf(form.getYearOfBorn()));
		author.setYearOfDead(Integer.valueOf(form.getYearOfDead()));
		author.setWiki(form.getWiki());
		author.setBiography(form.getBiography());
		author.setVersion(form.getVersion());
		MultipartFile file = form.getFile();
		author = authorDao.saveAndFlush(author);
		if(fileWriter.write(Folder.AUTHOR, file, author.getId())){
			author.setVersion(author.getVersion()+1);
			authorDao.save(author);
		}
	}

	@Override
	public AuthorForm findForm(int id) {
		AuthorForm form = new AuthorForm();
		Author author = authorDao.findOne(id);
		form.setId(author.getId());
		form.setName(author.getName());
		form.setSurname(author.getSurname());
		form.setYearOfBorn(String.valueOf(author.getYearOfBorn()));
		form.setYearOfDead(String.valueOf(author.getYearOfDead()));
		form.setWiki(author.getWiki());
		form.setBiography(author.getBiography());
		form.setVersion(author.getVersion());
		return form;
	}

	@Override
	public Author findUnique(String name, String surname, String yearOfBorn,
			String yearOfDead, String wiki) {
		return authorDao.findUnique(name, surname, Integer.valueOf(yearOfBorn), Integer.valueOf(yearOfDead), wiki);
	}

	@Override
	public Page<Author> findAll(Pageable pageable, SimpleFilter filter) {
		return authorDao.findAll(new AuthorSpecification(filter), pageable);
	}


}
