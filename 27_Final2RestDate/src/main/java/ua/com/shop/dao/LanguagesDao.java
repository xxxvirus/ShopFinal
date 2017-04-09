package ua.com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.shop.entity.Languages;

public interface LanguagesDao extends JpaRepository<Languages, Integer>, JpaSpecificationExecutor<Languages> {

	@Query("select l from Languages l where l.lang=:param")
	Languages selectLang(@Param("param") String langName);
	@Query("select l from Languages l where l.lang=:param")
	Languages findByName(@Param("param") String name);
	@Query("select l from Languages l join l.shop sh where sh.id=?1")
	List<Languages> findAuthorLang(int id);
}
