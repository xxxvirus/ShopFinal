package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.TitleShop;
import ua.com.shop.service.TitleShopService;

public class TitleShopEditor extends PropertyEditorSupport {

	private final TitleShopService titleShopService;
	
	public TitleShopEditor(TitleShopService titleShopService) {
		this.titleShopService = titleShopService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		TitleShop titleShop = titleShopService.findOne(Integer.valueOf(text));
		setValue(titleShop);
	}
}
