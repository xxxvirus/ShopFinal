package ua.com.shop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.LanguagesDao;
import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Languages;
import ua.com.shop.service.LanguagesService;
import ua.com.shop.specification.LanguagesSpecification;

@Service
public class LanguagesServiceImpl implements LanguagesService {

	@Autowired
	private LanguagesDao langDao;
	
	@Override
	public Languages save(Languages languages) {
		return langDao.saveAndFlush(languages);
	}

	@Override
	public List<Languages> findAll() {
		return langDao.findAll();
	}

	@Override
	public Languages findOne(int id) {
		return langDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		langDao.delete(id);
	}

	@Override
	public void update(Languages languages) {
		langDao.save(languages);
	}

	@Override
	public Languages selectLang(String langName) {
		return langDao.selectLang(langName);
	}

	@Override
	public Languages findByName(String name) {
		return langDao.findByName(name);
	}

	@Override
	public Page<Languages> findAll(Pageable pageable, SimpleFilter filter) {
		return langDao.findAll(new LanguagesSpecification(filter), pageable);
	}

	@Override
	public List<Languages> findAuthorLang(int id) {
		return langDao.findAuthorLang(id);
	}

}
