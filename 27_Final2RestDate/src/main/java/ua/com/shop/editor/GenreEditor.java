package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.Genre;
import ua.com.shop.service.GenreService;

public class GenreEditor extends PropertyEditorSupport {

	private final GenreService genreService;
	
	public GenreEditor(GenreService genreService) {
		this.genreService = genreService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Genre genre = genreService.findOne(Integer.valueOf(text));
		setValue(genre);
	}
}
