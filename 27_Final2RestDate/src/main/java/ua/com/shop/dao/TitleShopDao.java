package ua.com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.TitleShop;

public interface TitleShopDao extends JpaRepository<TitleShop, Integer>, JpaSpecificationExecutor<TitleShop> {

	@Query("select ts from TitleShop ts where ts.namePub=?1 and ts.book.id=?2")
	TitleShop findByUnique(String namePub, int bookId);
	
	@Query("select ts from TitleShop ts where ts.book.author.id=?1")
	List<TitleShop> findByAuthorId(int id);
	
	@Query("SELECT ts FROM TitleShop ts LEFT JOIN FETCH ts.book WHERE ts.id = ?1")
	TitleShop findOne(int id);
}
