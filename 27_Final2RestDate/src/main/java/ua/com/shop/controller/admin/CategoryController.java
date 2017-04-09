package ua.com.shop.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Category;
import ua.com.shop.service.CategoryService;

@RestController
@RequestMapping("/admin/category")
public class CategoryController {
	
	@Autowired
	private CategoryService catService;
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter(){
		return new SimpleFilter();
	}
	
	@ModelAttribute("category")
	public Category getForm(){
		return new Category();
	}
	
	@GetMapping(headers={"Accept=application/json"})
	public List<Category> findAll() {
		return catService.findAll();
	}

	@RequestMapping("/{id}")
	public Category findOne(@PathVariable int id) {
		return catService.findOne(id);
	}

	@PutMapping
	public Category save(@RequestBody Category category) {
		return catService.save(category);
	}

	@DeleteMapping("/{id}")
	public HttpStatus delete(@PathVariable int id) {
		catService.delete(id);
		return HttpStatus.OK;
	}

}
