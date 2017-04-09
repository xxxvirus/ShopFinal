package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.TitleShop;
import ua.com.shop.service.TitleShopService;

public class TitleShopValidator implements Validator {

	private final TitleShopService titleShopService;
	
	public TitleShopValidator(TitleShopService titleShopService) {
		this.titleShopService = titleShopService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return TitleShop.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		TitleShop titleShop = (TitleShop) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "namePub", "", "Can't be empty");
		if(titleShopService.findByUnique(titleShop.getNamePub(), titleShop.getBook().getId())!=null){
			errors.rejectValue("namePub", "", "Already exist");
		}
	}

}
