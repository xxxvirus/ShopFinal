package ua.com.shop.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.OrdersDao;
import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.dto.rest.OrdersDto;
import ua.com.shop.entity.Orders;
import ua.com.shop.service.OrdersService;
import ua.com.shop.specification.OrdersSpecification;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersDao ordersDao;

	@Override
	public void save(Orders orders) {
		ordersDao.save(orders);
	}

	@Override
	public Orders findOne(int id) {
		return ordersDao.findOne(id);
	}

	@Override
	public List<Orders> findAll() {
		return ordersDao.findAll();
	}

	@Override
	public void delete(int id) {
		ordersDao.delete(id);
	}

	@Override
	public void update(Orders orders) {
		ordersDao.save(orders);
	}

	@Override
	public Orders loaded(int id) {
		return ordersDao.loaded(id);
	}

	@Override
	public Page<Orders> findAll(Pageable pageable, SimpleFilter filter) {
		return ordersDao.findAll(new OrdersSpecification(filter), pageable);
	}

	@Override
	public List<OrdersDto> findAllDto() {
		return ordersDao.findAll().stream().map(this::map).collect(Collectors.toList());
	}
	
	private OrdersDto map(Orders order){
		OrdersDto dto = new OrdersDto();
		dto.setId(order.getId());
		dto.setUserEmail(order.getUser().getEmail());
		dto.setUserName(order.getUser().getName());
		dto.setUserSurname(order.getUser().getSurname());
		dto.setUserPhoneNumber(order.getUser().getPhoneNumber());
		return dto;
	}

}
