package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Publisher;
import ua.com.shop.service.PublisherService;

public class PublisherValidator implements Validator {

	private final PublisherService publisherService;
	
	public PublisherValidator(PublisherService publisherService) {
		this.publisherService = publisherService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Publisher.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Publisher publisher = (Publisher) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can't be empty");
		if(publisherService.findByName(publisher.getName())!=null){
			errors.rejectValue("name", "", "Already exist");
		}
	}

}
