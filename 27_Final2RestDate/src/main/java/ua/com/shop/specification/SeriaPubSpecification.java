package ua.com.shop.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.shop.dto.filter.SeriaPubFilter;
import ua.com.shop.entity.SeriaPub;

public class SeriaPubSpecification implements Specification<SeriaPub>{

	private final SeriaPubFilter filter;
	
	private final List<Predicate> predicates = new ArrayList<>();
	
	public SeriaPubSpecification(SeriaPubFilter filter) {
		this.filter = filter;
	}
	
	private void filterByPublisher(Root<SeriaPub> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getPublisherIds().isEmpty()){
			predicates.add(root.get("publisher").in(filter.getPublisherIds()));
		}
	}
	
	private void fetch(Root<SeriaPub> root, CriteriaQuery<?> query){
		if(!query.getResultType().equals(Long.class)){
			root.fetch("publisher");
		}
	}


	@Override
	public Predicate toPredicate(Root<SeriaPub> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		fetch(root, query);
		filterByPublisher(root, query, cb);
		if(predicates.isEmpty()) return null;
		Predicate[] array = new Predicate[predicates.size()];
		array = predicates.toArray(array);
		return cb.and(array);
	}

}
