package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.dto.form.ShopForm;
import ua.com.shop.service.ShopService;

public class ShopValidator implements Validator {

	private final static Pattern REG = Pattern
			.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");

	private final ShopService shopService;

	public ShopValidator(ShopService shopService) {
		this.shopService = shopService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return ShopForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ShopForm form = (ShopForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbn", "",
				"Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "anotation", "", "Can't be empty");
		if (!REG.matcher(form.getShpage()).matches()) {
			errors.rejectValue("shpage", "", "Enter only numbers");
		}
		if (errors.getFieldError("shpage") == null) {
			if (!REG.matcher(form.getShyear()).matches()) {
				errors.rejectValue("shyear", "", "Enter only numbers");
			}
			if (errors.getFieldError("shyear") == null) {
				if (!REG.matcher(form.getEdition()).matches()) {
					errors.rejectValue("edition", "", "Enter only numbers");
				}
				if (errors.getFieldError("edition") == null) {
					if (!REG.matcher(form.getShprice()).matches()) {
						errors.rejectValue("shprice", "", "Enter only numbers");
					}
					if (errors.getFieldError("shprice") == null) {
						if (shopService.findUnique(form.getShyear(),
								form.getShprice(), form.getIsbn(),
								form.getEdition(), form.getShpage(),
								form.getTitleSh(), form.getShSeria(),
								form.getShlang(), form.getShcat()) != null) {
							errors.rejectValue("titleSh", "", "Already exist");
						}
					}
				}
			}
		}
	}

}
