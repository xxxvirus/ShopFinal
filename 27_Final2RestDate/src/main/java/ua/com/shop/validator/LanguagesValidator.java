package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Languages;
import ua.com.shop.service.LanguagesService;

public class LanguagesValidator implements Validator {

	private final LanguagesService languagesService;
	
	public LanguagesValidator(LanguagesService languagesService) {
		this.languagesService = languagesService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Languages.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Languages language = (Languages) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lang", "", "Can't be empty");
		if(languagesService.findByName(language.getLang())!=null){
			errors.rejectValue("lang", "", "Already exist");
		}
	}

}
