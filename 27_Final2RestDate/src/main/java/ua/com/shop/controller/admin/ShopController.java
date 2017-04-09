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

import ua.com.shop.dto.filter.ShopFilter;
import ua.com.shop.dto.form.ShopForm;
import ua.com.shop.editor.CategoryEditor;
import ua.com.shop.editor.LangEditor;
import ua.com.shop.editor.SeriaPubEditor;
import ua.com.shop.editor.TitleShopEditor;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Languages;
import ua.com.shop.entity.SeriaPub;
import ua.com.shop.entity.TitleShop;
import ua.com.shop.service.CategoryService;
import ua.com.shop.service.LanguagesService;
import ua.com.shop.service.PublisherService;
import ua.com.shop.service.SeriaPubService;
import ua.com.shop.service.ShopService;
import ua.com.shop.service.TitleShopService;
import ua.com.shop.util.ParamBuilder;
import ua.com.shop.validator.ShopValidator;

@Controller
@RequestMapping("/admin/shop")
@SessionAttributes("shop")
public class ShopController {

	@Autowired
	private ShopService shopService;
	@Autowired
	private TitleShopService titleShopService;
	@Autowired
	private CategoryService catService;
	@Autowired
	private LanguagesService langService;
	@Autowired
	private SeriaPubService seriaPubService;
	@Autowired
	private PublisherService publisherService;

	@InitBinder("shop")
	protected void bind(WebDataBinder binder) {
		binder.registerCustomEditor(TitleShop.class, new TitleShopEditor(
				titleShopService));
		binder.registerCustomEditor(Category.class, new CategoryEditor(
				catService));
		binder.registerCustomEditor(Languages.class,
				new LangEditor(langService));
		binder.registerCustomEditor(SeriaPub.class, new SeriaPubEditor(
				seriaPubService));
		binder.setValidator(new ShopValidator(shopService));
	}

	@ModelAttribute("filter")
	public ShopFilter getFilter() {
		return new ShopFilter();
	}

	@ModelAttribute("shop")
	public ShopForm getForm() {
		return new ShopForm();
	}

	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") ShopFilter filter) {
		model.addAttribute("page", shopService.findAll(pageable, filter));
		model.addAttribute("titleShops", titleShopService.findAll());
		model.addAttribute("categories", catService.findAll());
		model.addAttribute("langM", langService.findAll());
		model.addAttribute("series", seriaPubService.findAll());
		model.addAttribute("publishers", publisherService.findAll());
		return "admin-shop";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") ShopFilter filter) {
		shopService.delete(id);
		return "redirect:/admin/shop" + getParams(pageable, filter);
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") ShopFilter filter) {
		model.addAttribute("shop", shopService.findForm(id));
		return show(model, pageable, filter);
	}

	@PostMapping
	public String save(@ModelAttribute("shop") @Valid ShopForm shop,
			BindingResult br, Model model, SessionStatus status,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") ShopFilter filter) {
		if (br.hasErrors())
			return show(model, pageable, filter);
		shopService.save(shop);
		status.setComplete();
		return "redirect:/admin/shop" + getParams(pageable, filter);
	}

	private String getParams(Pageable pageable, ShopFilter filter) {
		String page = ParamBuilder.getParams(pageable);
		StringBuilder buffer = new StringBuilder(page);
		if (!filter.getMax().isEmpty()) {
			buffer.append("&max=");
			buffer.append(filter.getMax());
		}
		if (!filter.getMin().isEmpty()) {
			buffer.append("&min=");
			buffer.append(filter.getMin());
		}
		if (!filter.getLanguageIds().isEmpty()) {
			for (Integer id : filter.getLanguageIds()) {
				buffer.append("&languageIds=");
				buffer.append(id);
			}
		}
		if (!filter.getCategoryIds().isEmpty()) {
			for (Integer id : filter.getCategoryIds()) {
				buffer.append("&categoryIds=");
				buffer.append(id);
			}
		}
		if (!filter.getPublisherIds().isEmpty()) {
			for (Integer id : filter.getPublisherIds()) {
				buffer.append("&publisherIds=");
				buffer.append(id);
			}
		}
		return buffer.toString();
	}
}
