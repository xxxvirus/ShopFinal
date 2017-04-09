package ua.com.shop.controller.admin;

import static ua.com.shop.util.ParamBuilder.*;

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
import ua.com.shop.editor.BookEditor;
import ua.com.shop.entity.Book;
import ua.com.shop.entity.TitleShop;
import ua.com.shop.service.BookService;
import ua.com.shop.service.TitleShopService;
import ua.com.shop.validator.TitleShopValidator;

@Controller
@RequestMapping("/admin/titleSh")
@SessionAttributes("titleSh")
public class TitleShopController {

	@Autowired
	private TitleShopService titleShopService;
	@Autowired
	private BookService bookService;
	
	@InitBinder("titleSh")
	protected void bind(WebDataBinder binder){
		binder.registerCustomEditor(Book.class, new BookEditor(bookService));
		binder.setValidator(new TitleShopValidator(titleShopService));
	}
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter(){
		return new SimpleFilter();
	}
	
	@ModelAttribute("titleSh")
	public TitleShop getForm(){
		return new TitleShop();
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		model.addAttribute("page", titleShopService.findAll(pageable, filter));
		model.addAttribute("books", bookService.findAll());
		return "admin-titleSh";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		model.addAttribute("titleSh", titleShopService.findOne(id));
		return show(model, pageable, filter);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		titleShopService.delete(id);
		return "redirect:/admin/titleSh"+getParams(pageable, filter);
	}
	
	@PostMapping
	public String save(@ModelAttribute("titleSh") @Valid TitleShop titleShop, BindingResult br, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		if(br.hasErrors()){
			return show(model, pageable, filter);
		}
		titleShopService.save(titleShop);
		status.setComplete();
		return "redirect:/admin/titleSh"+getParams(pageable, filter);
	}
}
