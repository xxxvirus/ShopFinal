package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.Book;
import ua.com.shop.service.BookService;

public class BookEditor extends PropertyEditorSupport {

	private final BookService bookService;
	
	public BookEditor(BookService bookService) {
		this.bookService = bookService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Book book = bookService.findOne(Integer.valueOf(text));
		setValue(book);
	}
}
