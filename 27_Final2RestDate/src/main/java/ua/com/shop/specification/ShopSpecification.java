package ua.com.shop.specification;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.shop.dto.filter.ShopFilter;
import ua.com.shop.entity.Shop;

public class ShopSpecification implements Specification<Shop> {

	private final ShopFilter filter;
	private final List<Predicate> predicates = new ArrayList<>();
	
	private final static Pattern PATTERN = Pattern.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");
	
	public ShopSpecification(ShopFilter filter) {
		this.filter = filter;
		if(PATTERN.matcher(filter.getMax()).matches()){
			filter.setMaxValue(new BigDecimal(filter.getMax().replace(',', '.')));
		}
		if(PATTERN.matcher(filter.getMin()).matches()){
			filter.setMinValue(new BigDecimal(filter.getMin().replace(',', '.')));
		}
	}
	
	private void filterByLanguage(Root<Shop> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getLanguageIds().isEmpty()){
			predicates.add(root.get("shlang").in(filter.getLanguageIds()));
		}
	}
	
	private void filterByCategory(Root<Shop> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getCategoryIds().isEmpty()){
			predicates.add(root.get("shcat").in(filter.getCategoryIds()));
		}
	}
	
	private void filterByPublisher(Root<Shop> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getPublisherIds().isEmpty()){
			predicates.add(root.get("shSeria").in(filter.getPublisherIds()));
		}
	}
	
	private void filterByprice(Root<Shop> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(filter.getMaxValue()!=null){
			predicates.add(cb.le(root.get("shprice"), filter.getMaxValue()));
		}
		if(filter.getMinValue()!=null){
			predicates.add(cb.ge(root.get("shprice"), filter.getMinValue()));
		}
	}
	
	private void filterBySearch(Root<Shop> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getSearch().isEmpty()){
			predicates.add(cb.like(root.get("titleSh").get("namePub"), filter.getSearch()+"%"));
		}
	}
	
	private void fetch(Root<Shop> root, CriteriaQuery<?> query){
		if(!query.getResultType().equals(Long.class)){
			query.distinct(true);
			root.fetch("shlang");
			root.fetch("shcat");
			root.fetch("shSeria").fetch("publisher");
		}
	}

	@Override
	public Predicate toPredicate(Root<Shop> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		fetch(root, query);
		filterBySearch(root, query, cb);
		filterByprice(root, query, cb);
		filterByLanguage(root, query, cb);
		filterByCategory(root, query, cb);
		filterByPublisher(root, query, cb);
		if(predicates.isEmpty()) return null;
		Predicate[] array = new Predicate[predicates.size()];
		array = predicates.toArray(array);
		return cb.and(array);
	}

}
