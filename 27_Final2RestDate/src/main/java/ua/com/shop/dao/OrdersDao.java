package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.shop.entity.Orders;

public interface OrdersDao extends JpaRepository<Orders, Integer>,
		JpaSpecificationExecutor<Orders> {

	@Query("SELECT DISTINCT o FROM Orders o LEFT JOIN FETCH o.shops WHERE "
			+ "o.id=:id")
	Orders loaded(@Param("id") int id);
}
