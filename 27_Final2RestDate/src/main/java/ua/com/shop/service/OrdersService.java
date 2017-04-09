package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.dto.rest.OrdersDto;
import ua.com.shop.entity.Orders;

public interface OrdersService {

	void save(Orders orders);
	Orders findOne(int id);
	List<Orders> findAll();
	void delete(int id);
	void update(Orders orders);

	Orders loaded(int id);
	Page<Orders> findAll(Pageable pageable, SimpleFilter filter);
	List<OrdersDto> findAllDto();
}
