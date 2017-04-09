package ua.com.shop.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.shop.dto.filter.OrderFilter;
import ua.com.shop.entity.Orders;
import ua.com.shop.entity.Shop;

public class OrderSpecification implements Specification<Orders> {

	private final OrderFilter filter;
	private final List<Predicate> predicates = new ArrayList<>();

	public OrderSpecification(OrderFilter filter) {
		this.filter = filter;
	}

	@Override
	public Predicate toPredicate(Root<Orders> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	private void filterBySend(Root<Shop> root, CriteriaQuery<?> query, CriteriaBuilder cb){
//		if(!filter.getSend()){
//			predicates.add(root.get("send").in(filter.getSend()));
//		}
//	}
//	
//	private void filterBySearch(Root<Shop> root, CriteriaQuery<?> query, CriteriaBuilder cb){
//		if(!filter.getSearch().isEmpty()){
//			predicates.add(cb.like(root.get("user").get("email"), filter.getSearch()+"%"));
//		}
//	}
//
//	@Override
//	public Predicate toPredicate(Root<Orders> root, CriteriaQuery<?> query,
//			CriteriaBuilder cb) {
//		filterBySearch(root, query, cb);
//		if(predicates.isEmpty()) return null;
//		Predicate[] array = new Predicate[predicates.size()];
//		array = predicates.toArray(array);
//		return cb.and(array);
//	}

}
