package ua.com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.shop.entity.Genre;

public interface GenreDao extends JpaRepository<Genre, Integer>, JpaSpecificationExecutor<Genre> {

	@Query("SELECT DISTINCT g FROM Genre g LEFT JOIN FETCH g.book WHERE "
			+ "g.id=:id")
	Genre loadedBook(@Param("id") int id);

	@Query("select DISTINCT g from Genre g left join fetch g.book")
	List<Genre> findAll();
	@Query("select g from Genre g where g.nameOfG=:param")
	Genre findByName(@Param("param") String nameOfG);
}
