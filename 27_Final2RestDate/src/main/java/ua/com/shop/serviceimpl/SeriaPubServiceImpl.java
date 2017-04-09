package ua.com.shop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.PublisherDao;
import ua.com.shop.dao.SeriaPubDao;
import ua.com.shop.dto.filter.SeriaPubFilter;
import ua.com.shop.entity.SeriaPub;
import ua.com.shop.service.SeriaPubService;
import ua.com.shop.specification.SeriaPubSpecification;

@Service
public class SeriaPubServiceImpl implements SeriaPubService{

	@Autowired
	private SeriaPubDao seriaPubDao;
	@Autowired
	private PublisherDao publisherDao;
	
	public void save(SeriaPub seriaPub) {
		seriaPubDao.save(seriaPub);
	}

	public List<SeriaPub> findAll() {
		return seriaPubDao.findAll();
	}

	public SeriaPub findOne(int id) {
		return seriaPubDao.findOne(id);
	}

	public void delete(int id) {
		seriaPubDao.delete(id);
	}

	public void update(SeriaPub seriaPub) {
		seriaPubDao.save(seriaPub);
	}

	@Override
	public SeriaPub selectSeria(String seriaName) {
		return seriaPubDao.selectSeria(seriaName);
	}

//	public void createPublisherAndSeria(String seriaName, String nameOfP) {
//		SeriaPub seriaPub = seriaPubDao.selectSeria(seriaName);
//		Publisher publisher = publisherDao.selectPublisher(nameOfP);
//		if(seriaPub==null){
//			SeriaPub seriaPub1 = new SeriaPub(seriaName);
//			seriaPubDao.save(seriaPub1);
//		}
//		if(publisher!=null){
//			SeriaPub seriaPub2 = seriaPubDao.selectSeria(seriaName);
//			seriaPub2.setPublisher(publisher);
//			seriaPubDao.save(seriaPub2);
//		}else{
//			Publisher publisher2 = new Publisher(nameOfP);
//			publisherDao.save(publisher2);
//			SeriaPub seriaPub3 = seriaPubDao.selectSeria(seriaName);
//			seriaPub3.setPublisher(publisher2);
//			seriaPubDao.save(seriaPub3);
//		}
//	}

	@Override
	public List<SeriaPub> findByPublisherId(int id) {
		return seriaPubDao.findByPublisherId(id);
	}

	@Override
	public SeriaPub findByUnique(String nameOfS, int publisherId) {
		return seriaPubDao.findByUnique(nameOfS, publisherId);
	}

	@Override
	public Page<SeriaPub> findAll(Pageable pageable, SeriaPubFilter filter) {
		return seriaPubDao.findAll(new SeriaPubSpecification(filter), pageable);
	}

}
