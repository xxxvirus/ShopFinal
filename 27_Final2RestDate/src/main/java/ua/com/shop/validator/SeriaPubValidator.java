package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.SeriaPub;
import ua.com.shop.service.SeriaPubService;

public class SeriaPubValidator implements Validator {

	private final SeriaPubService seriaPubService;
	
	public SeriaPubValidator(SeriaPubService seriaPubService) {
		this.seriaPubService = seriaPubService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return SeriaPub.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SeriaPub seriaPub = (SeriaPub) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nameOfS", "", "Can't be empty");
		if(seriaPubService.findByUnique(seriaPub.getNameOfS(), seriaPub.getPublisher().getId())!=null){
			errors.rejectValue("nameOfS", "", "Already exist");
		}
	}

}
