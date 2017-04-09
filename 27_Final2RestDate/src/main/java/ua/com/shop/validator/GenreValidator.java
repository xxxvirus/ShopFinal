package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Genre;
import ua.com.shop.service.GenreService;

public class GenreValidator implements Validator {

	private final GenreService genreService;
	
	public GenreValidator(GenreService genreService) {
		this.genreService = genreService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Genre.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Genre genre = (Genre) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nameOfG", "", "Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "aboutG", "", "Can't be empty");
		if(genreService.findByName(genre.getNameOfG())!=null){
			errors.rejectValue("nameOfG", "", "Already exist");
		}
	}

}
