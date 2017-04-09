package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.dto.form.BookForm;
import ua.com.shop.service.BookService;

public class BookValidator implements Validator {

	private final static Pattern REG = Pattern.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");
	
	private final BookService bookService;

	public BookValidator(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return BookForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BookForm form = (BookForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "", "Can't be empty");
//		int idx = 0;
//		for (Genre genre : form.getGenre()) {
//			errors.pushNestedPath("genre[" + idx + "]");
//		}
//		for (int i = 0; i < form.getGenre().size(); i++) {
//			Genre genre = form.getGenre().get(i);
//			if(genre==null) {
//                errors.rejectValue("genre[" + i + "]", "your_error_code");
//            }
//		}
		if(!REG.matcher(form.getFirstpub()).matches()){
			errors.rejectValue("firstpub", "", "Enter only numbers");
		}
		if(errors.getFieldError("firstpub")==null){
			if(bookService.findUnique(form.getTitle(), form.getFirstpub(), form.getAuthor())!=null){
				errors.rejectValue("title", "", "Already exist");
			}
		}
	}
	
	
}
