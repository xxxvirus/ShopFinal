package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.dto.form.AuthorForm;
import ua.com.shop.service.AuthorService;

public class AuthorValidator implements Validator {

	private final static Pattern REG = Pattern.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");
	private final AuthorService authorService;
	
	public AuthorValidator(AuthorService authorService) {
		this.authorService = authorService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return AuthorForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		AuthorForm form = (AuthorForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "", "Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "wiki", "", "Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "biography", "", "Can't be empty");
		if(!REG.matcher(form.getYearOfBorn()).matches()){
			errors.rejectValue("yearOfBorn", "", "Enter only numbers");
		}
		if(errors.getFieldError("yearOfBorn")==null){
			if(!REG.matcher(form.getYearOfDead()).matches()){
				errors.rejectValue("yearOfDead", "", "Enter only numbers or 0");
			}
			if(errors.getFieldError("yearOfDead")==null){
				if(authorService.findUnique(form.getName(), form.getSurname(), form.getYearOfBorn(), form.getYearOfDead(), form.getWiki())!=null){
					errors.rejectValue("name", "", "Already exist");
				}
			}
		}
	}

}
