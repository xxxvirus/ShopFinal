package ua.com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.shop.entity.Book;

public interface BookDao extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {

	
	@Query("select b from Book b join b.author a where a.name=:name and a.surname=:surname")
	Book authorS(@Param("name") String authorName,
			@Param("surname") String authorSurname);
	@Query("select b from Book b where b.author.id=?1")
	List<Book> findByAuthorId(int id);
	@Query("select b from Book b left join fetch b.author left join fetch b.genre where b.id=?1")
	Book findOne(int id);
	@Query("SELECT b FROM Book b WHERE b.title=?1 and b.firstpub=?2 and b.author.id=?3")
	Book findUnique(String title, int firstpub, int authorId);
	
}
