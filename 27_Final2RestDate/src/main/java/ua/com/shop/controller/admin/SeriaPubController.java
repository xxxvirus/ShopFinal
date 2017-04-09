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

import ua.com.shop.dto.filter.SeriaPubFilter;
import ua.com.shop.editor.PublisherEditor;
import ua.com.shop.entity.Publisher;
import ua.com.shop.entity.SeriaPub;
import ua.com.shop.service.PublisherService;
import ua.com.shop.service.SeriaPubService;
import ua.com.shop.validator.SeriaPubValidator;
import ua.com.shop.util.ParamBuilder;

@Controller
@RequestMapping("/admin/seriaPub")
@SessionAttributes("seriaPub")
public class SeriaPubController {

	@Autowired
	private SeriaPubService seriaPubService;
	@Autowired
	private PublisherService publisherService;

	@InitBinder("seriaPub")
	protected void bind(WebDataBinder binder) {
		binder.registerCustomEditor(Publisher.class, new PublisherEditor(
				publisherService));
		binder.setValidator(new SeriaPubValidator(seriaPubService));
	}

	@ModelAttribute("filter")
	public SeriaPubFilter getFilter(){
		return new SeriaPubFilter();
	}
	
	@ModelAttribute("seriaPub")
	public SeriaPub getForm() {
		return new SeriaPub();
	}

	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SeriaPubFilter filter) {
		model.addAttribute("page", seriaPubService.findAll(pageable, filter));
		model.addAttribute("publishers", publisherService.findAll());
		return "admin-seriaPub";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SeriaPubFilter filter) {
		model.addAttribute("seriaPub", seriaPubService.findOne(id));
		return show(model, pageable, filter);
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SeriaPubFilter filter) {
		seriaPubService.delete(id);
		return "redirect:/admin/seriaPub"+getParams(pageable, filter);
	}

	@PostMapping
	public String save(@ModelAttribute("seriaPub") @Valid SeriaPub seriaPub,
			BindingResult br, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") SeriaPubFilter filter) {
		if(br.hasErrors()){
			return show(model, pageable, filter);
		}
		seriaPubService.save(seriaPub);
		status.setComplete();
		return "redirect:/admin/seriaPub"+getParams(pageable, filter);
	}
	
	private String getParams(Pageable pageable, SeriaPubFilter filter){
		String page = ParamBuilder.getParams(pageable);
		StringBuilder buffer = new StringBuilder(page);
		if(!filter.getPublisherIds().isEmpty()){
			for (Integer id : filter.getPublisherIds()) {
				buffer.append("&publisherIds=");
				buffer.append(id);
			}
		}
		return buffer.toString();
	}

}
