package ua.com.shop.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Category;
import ua.com.shop.service.CategoryService;

public class CategoryValidator implements Validator{

	private final CategoryService categoryService;
	
	public CategoryValidator(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Category.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Category category = (Category) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nameOfC", "", "Can't be empty");
		if(categoryService.findByName(category.getNameOfC())!=null){
			errors.rejectValue("nameOfC", "", "Already exist");
		}
	}

}
