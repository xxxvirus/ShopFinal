package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.Publisher;
import ua.com.shop.service.PublisherService;

public class PublisherEditor extends PropertyEditorSupport {
	
	private final PublisherService publisherService;
	
	public PublisherEditor(PublisherService publisherService) {
		this.publisherService = publisherService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Publisher publisher = publisherService.findOne(Integer.valueOf(text));
		setValue(publisher);
	}

}
