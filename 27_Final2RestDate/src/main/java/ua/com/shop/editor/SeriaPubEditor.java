package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.SeriaPub;
import ua.com.shop.service.SeriaPubService;

public class SeriaPubEditor extends PropertyEditorSupport{

	private final SeriaPubService seriaService;
	
	public SeriaPubEditor(SeriaPubService seriaService) {
		this.seriaService = seriaService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		SeriaPub seriaPub = seriaService.findOne(Integer.valueOf(text));
		setValue(seriaPub);
	}
}
