package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Publisher;

public interface PublisherService {

	Publisher save(Publisher publisher);
	List<Publisher> findAll();
	Publisher findOne(int id);
	void delete(int id);
	void update(Publisher publisher);
	
	Publisher selectPublisher(String nameOfP);
	Publisher findByName(String name);
	Page<Publisher> findAll(Pageable pageable, SimpleFilter filter);
	List<Publisher> findAuthorPub(int id);
}
