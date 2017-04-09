package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.shop.entity.Author;

public interface AuthorDao extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {

	@Query("select a from Author a where a.name=:param and a.surname=:param1")
	Author selectAuthor(@Param("param") String authorName,
			@Param("param1") String authorSurname);
	@Query("select a from Author a left join fetch a.books where a.name=:param and a.surname=:param1")
	Author fetchAuthor(@Param("param") String authorName, @Param("param1") String authorSurname);
	
	@Query("SELECT a FROM Author a WHERE a.name=?1 and a.surname=?2 and a.yearOfBorn=?3 and a.yearOfDead=?4 and a.wiki=?5")
	Author findUnique(String name, String surname, int yearOfBorn, int yearOfDead, String wiki);
}
