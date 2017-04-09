package ua.com.shop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.PublisherDao;
import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Publisher;
import ua.com.shop.service.PublisherService;
import ua.com.shop.specification.PublisherSpecification;

@Service
public class PublisherServiceImpl implements PublisherService{

	@Autowired
	private PublisherDao publisherDao;
	
	public Publisher save(Publisher publisher) {
		return publisherDao.saveAndFlush(publisher);
	}

	public List<Publisher> findAll() {
		return publisherDao.findAll();
	}

	public Publisher findOne(int id) {
		return publisherDao.findOne(id);
	}

	public void delete(int id) {
		publisherDao.delete(id);
	}

	public void update(Publisher publisher) {
		publisherDao.save(publisher);
	}

	@Override
	public Publisher selectPublisher(String nameOfP) {
		return publisherDao.selectPublisher(nameOfP);
	}

	@Override
	public Publisher findByName(String name) {
		return publisherDao.findByName(name);
	}

	@Override
	public Page<Publisher> findAll(Pageable pageable, SimpleFilter filter) {
		return publisherDao.findAll(new PublisherSpecification(filter), pageable);
	}

	@Override
	public List<Publisher> findAuthorPub(int id) {
		return publisherDao.findAuthorPub(id);
	}

}
