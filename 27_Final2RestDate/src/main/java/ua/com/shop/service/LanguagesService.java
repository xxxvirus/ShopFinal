package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Languages;

public interface LanguagesService {

	Languages save(Languages languages);
	List<Languages> findAll();
	Languages findOne(int id);
	void delete(int id);
	void update(Languages languages);
	Languages selectLang(String langName);
	Languages findByName(String name);
	Page<Languages> findAll(Pageable pageable, SimpleFilter filter);
	List<Languages> findAuthorLang(int id);
}
