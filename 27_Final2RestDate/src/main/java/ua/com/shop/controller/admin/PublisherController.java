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
import ua.com.shop.entity.Publisher;
import ua.com.shop.service.PublisherService;

@RestController
@RequestMapping("/admin/publisher")
public class PublisherController {
	
	@Autowired
	private PublisherService publisherService;
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter(){
		return new SimpleFilter();
	}
	
	@ModelAttribute("publisher")
	public Publisher getForm(){
		return new Publisher();
	}
	
	@GetMapping(headers={"Accept=application/json"})
	public List<Publisher> findAll() {
		return publisherService.findAll();
	}

	@RequestMapping("/{id}")
	public Publisher findOne(@PathVariable int id) {
		return publisherService.findOne(id);
	}

	@PutMapping
	public Publisher save(@RequestBody Publisher publisher) {
		return publisherService.save(publisher);
	}

	@DeleteMapping("/{id}")
	public HttpStatus delete(@PathVariable int id) {
		publisherService.delete(id);
		return HttpStatus.OK;
	}

}
