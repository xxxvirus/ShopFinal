package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.shop.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>, JpaSpecificationExecutor<Category> {

//	@Query("select c from Category c where c.nameOfC=:param")
//	Category selectCategory(@Param("param") String categoryName);
	@Query("select c from Category c where c.nameOfC=:param")
	Category findByName(@Param("param") String name);
}
