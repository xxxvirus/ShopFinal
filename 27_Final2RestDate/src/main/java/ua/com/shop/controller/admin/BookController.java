package ua.com.shop.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.dto.form.BookForm;
import ua.com.shop.editor.AuthorEditor;
import ua.com.shop.editor.GenreEditor;
import ua.com.shop.entity.Author;
import ua.com.shop.entity.Genre;
import ua.com.shop.service.AuthorService;
import ua.com.shop.service.BookService;
import ua.com.shop.service.GenreService;
import ua.com.shop.validator.BookValidator;

@Controller
@RequestMapping("/admin/book")
@SessionAttributes("book")
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private AuthorService authorService;
	@Autowired
	private GenreService genreService;
	
	@InitBinder("book")
	protected void bind(WebDataBinder binder){
		binder.registerCustomEditor(Author.class, new AuthorEditor(authorService));
		binder.registerCustomEditor(Genre.class, new GenreEditor(genreService));
		binder.setValidator(new BookValidator(bookService));
	}
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter(){
		return new SimpleFilter();
	}
	
	@ModelAttribute("book")
	public BookForm getForm(){
		return new BookForm();
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		model.addAttribute("page", bookService.findAll(pageable, filter));
		model.addAttribute("authors", authorService.findAll());
		model.addAttribute("genres", genreService.findAll());
		return "admin-book";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		model.addAttribute("book", bookService.findForm(id));
		return show(model, pageable, filter);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		bookService.delete(id);
		return "redirect:/admin/book";
	}
	
	@PostMapping
	public String save(@ModelAttribute("book") @Valid BookForm book, BindingResult br, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		if(br.hasErrors()) return show(model, pageable, filter);
		bookService.save(book);
		status.setComplete();
		return "redirect:/admin/book";
	}
	
}
