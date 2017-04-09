package ua.com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.shop.entity.Publisher;

public interface PublisherDao extends JpaRepository<Publisher, Integer>, JpaSpecificationExecutor<Publisher> {

	@Query("select p from Publisher p where p.name=:param")
	Publisher selectPublisher(@Param("param") String nameOfP);

	Publisher findByName(String name);

	@Query("select p from Publisher p left join fetch p.listOfS sp where sp.id=:id")
	List<Publisher> findAuthorPub(@Param("id") int id);
	
	
}
