package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.Languages;
import ua.com.shop.service.LanguagesService;

public class LangEditor extends PropertyEditorSupport {

	private final LanguagesService langService;
	
	public LangEditor(LanguagesService langService) {
		this.langService = langService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Languages lang = langService.findOne(Integer.valueOf(text));
		setValue(lang);
	}
}
