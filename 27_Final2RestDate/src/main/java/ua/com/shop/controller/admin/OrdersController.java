package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Orders;
import ua.com.shop.service.OrdersService;
import ua.com.shop.service.ShopService;

@Controller
@RequestMapping("/admin/order")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;
	@Autowired
	private ShopService shopService;

	@ModelAttribute("filter")
	public SimpleFilter getFilter(){
		return new SimpleFilter();
	}

	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("page", ordersService.findAll(pageable, filter));
		return "admin-order";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		ordersService.delete(id);
		return "redirect:/admin/order";
	}
	
	@GetMapping("/send/{id}")
	public String send(@PathVariable int id) {
		Orders order = ordersService.findOne(id);
		order.setSend(true);
		ordersService.save(order);
		return "redirect:/admin/order";
	}
	
	@GetMapping("/unsend/{id}")
	public String unsend(@PathVariable int id) {
		ordersService.findOne(id).setSend(false);
		return "redirect:/admin/order";
	}
	
	@RequestMapping("/viewOrder/{id}")
	public String showAddNoss(@PathVariable int id, Model model){
		Orders order = ordersService.loaded(id);
		model.addAttribute("orders", order);
//		List<Shop> shops = shopService.findAll();
//		shops.removeAll(order.getShops());
//		model.addAttribute("shopsl", shops);
		return "admin-viewOrder";
	}

}
