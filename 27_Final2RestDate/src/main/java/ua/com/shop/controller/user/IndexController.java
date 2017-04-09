package ua.com.shop.controller.user;

import java.security.Principal;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
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
import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Orders;
import ua.com.shop.entity.Shop;
import ua.com.shop.entity.User;
import ua.com.shop.service.AuthorService;
import ua.com.shop.service.BookService;
import ua.com.shop.service.CategoryService;
import ua.com.shop.service.GenreService;
import ua.com.shop.service.LanguagesService;
import ua.com.shop.service.OrdersService;
import ua.com.shop.service.PublisherService;
import ua.com.shop.service.SeriaPubService;
import ua.com.shop.service.ShopService;
import ua.com.shop.service.TitleShopService;
import ua.com.shop.service.UserService;
import ua.com.shop.validator.UserValidator;

@Controller
@SessionAttributes({ "shop", "order" })
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private CategoryService catService;
	@Autowired
	private ShopService shopService;
	@Autowired
	private PublisherService publisherService;
	@Autowired
	private SeriaPubService seriaService;
	@Autowired
	private AuthorService authorService;
	@Autowired
	private TitleShopService titleShopService;
	@Autowired
	private LanguagesService langService;
	@Autowired
	private SeriaPubService seriaPubService;
	@Autowired
	private GenreService genreService;
	@Autowired
	private UserService userService;
	@Autowired
	private OrdersService ordersService;
	
	@ModelAttribute("order")
	public Orders getOrders() {
		return new Orders();
	}
	
	@GetMapping
	public String index(Principal principal, Model model, @ModelAttribute("order") Orders order){
		if(principal!=null){
			System.out.println(principal.getName());
			SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		return show(model, order);
	}
	
	public String show(Model model, @ModelAttribute("order") Orders order) {
		model.addAttribute("ord", order);
		model.addAttribute("categories", catService.findAll());
//		model.addAttribute("authors", authorService.findAll());
//		model.addAttribute("genres", genreService.findAll());
//		model.addAttribute("shops", shopService.findAll());
		//Popular
		model.addAttribute("first", shopService.findOne(1));
		model.addAttribute("second", shopService.findOne(2));
		model.addAttribute("third", shopService.findOne(3));
		model.addAttribute("fourth", shopService.findOne(4));
		model.addAttribute("fifth", shopService.findOne(5));
		model.addAttribute("sixth", shopService.findOne(6));
		model.addAttribute("seventh", shopService.findOne(7));
		model.addAttribute("eight", shopService.findOne(8));
		model.addAttribute("nineth", shopService.findOne(9));
		model.addAttribute("tenth", shopService.findOne(10));
		model.addAttribute("eleventh", shopService.findOne(11));
		model.addAttribute("twelveth", shopService.findOne(12));
		return "user-index";
	}
	
	@PostMapping("/addtocart/{id}")
	public String addToCart(Model model, @PageableDefault Pageable pageable, @PathVariable int id, @ModelAttribute("order") Orders order,
			@ModelAttribute("filter") ShopFilter filter) {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		order.setUser(user);
		Shop shop = shopService.findOne(id);
		if (order.getShops() == null)
			order.setShops(new ArrayList<Shop>());
		if (!order.getShops().contains(shop))
			order.getShops().add(shop);
		return show(model, order);
	}
	
	@PostMapping("/deletefromcart/{id}")
	public String deleteFromCart(Model model,@PathVariable int id, @ModelAttribute("order") Orders order) {
		order.getShops().remove(shopService.findOne(id));
		return "redirect:/shoppingcart";
	}
	
	@RequestMapping("/shoppingcart")
	public String shoppingcart(Model model, @ModelAttribute("order") Orders order) {
		model.addAttribute("qwer", order.getShops());
		return "user-shoppingcart";
	}

	@GetMapping("/makeorder")
	public String makeOrder(@ModelAttribute("order") Orders order,
			SessionStatus status) {
		if (order.getShops() != null && !order.getShops().isEmpty())
			ordersService.save(order);
		status.setComplete();
		return "redirect:/";
	}
	
	@ModelAttribute("filter")
	public ShopFilter getFilter(){
		return new ShopFilter();
	}
	
	@ModelAttribute("filterS")
	public SimpleFilter getFilteSr(){
		return new SimpleFilter();
	}
	
	@RequestMapping("/search")
	public String search(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") ShopFilter filter){
		model.addAttribute("page", shopService.findAll(pageable, filter));
		return "user-search";
	}
	
	@RequestMapping("/contact")
	public String contact(){
		return "user-contact";
	}
	
	@RequestMapping("/delivery")
	public String delivery(){
		return "user-delivery";
	}
	
	@RequestMapping("/payment")
	public String payment(){
		return "user-payment";
	}
	
	@RequestMapping("/about")
	public String about(){
		return "user-about";
	}
	
	@RequestMapping("/admin")
	public String admin(){
		return "admin-admin";
	}
	
	@InitBinder("user")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new UserValidator(userService));
	}
	
	@GetMapping("/registration")
	public String registration(Model model){
		model.addAttribute("user", new User());
		return "user-registration";
	}
	
	@PostMapping("/registration")
	public String save(@ModelAttribute("user") @Valid User user, BindingResult br, Model model){
		if (br.hasErrors())
			return "user-registration";
		userService.save(user);
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login(){
		return "user-login";
	}
	
	@RequestMapping(value="/admin/lang")
	public String lang(){
		return "admin-lang";
	}
	
	@RequestMapping(value="/admin/category")
	public String category(){
		return "admin-category";
	}
	
	@RequestMapping(value="/admin/publisher")
	public String publisher(){
		return "admin-publisher";
	}
	
}
