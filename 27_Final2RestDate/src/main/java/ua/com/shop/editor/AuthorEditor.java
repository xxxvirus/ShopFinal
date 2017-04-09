package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.Author;
import ua.com.shop.service.AuthorService;

public class AuthorEditor extends PropertyEditorSupport {

	private final AuthorService authorService;
	
	public AuthorEditor(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Author author = authorService.findOne(Integer.valueOf(text));
		setValue(author);
	}
}
