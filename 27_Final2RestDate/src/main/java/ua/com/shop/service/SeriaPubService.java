package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SeriaPubFilter;
import ua.com.shop.entity.SeriaPub;

public interface SeriaPubService {

	void save(SeriaPub seriaPub);
	List<SeriaPub> findAll();
	SeriaPub findOne(int id);
	void delete(int id);
	void update(SeriaPub seriaPub);
	
//	public void createPublisherAndSeria(String seriaName, String nameOfP);
	
	SeriaPub selectSeria(String seriaName);
	List<SeriaPub> findByPublisherId(int id);
	SeriaPub findByUnique(String nameOfS, int publisherId);
	Page<SeriaPub> findAll(Pageable pageable, SeriaPubFilter filter);
}
