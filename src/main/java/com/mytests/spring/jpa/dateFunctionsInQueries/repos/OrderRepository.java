package com.mytests.spring.jpa.dateFunctionsInQueries.repos;

import java.util.Date;
import java.util.List;

import com.mytests.spring.jpa.dateFunctionsInQueries.model.Order;
import com.mytests.spring.jpa.dateFunctionsInQueries.model.OrderIdAndAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; 
import org.springframework.data.repository.query.Param; 
import org.springframework.stereotype.Repository;

@Repository 
public interface OrderRepository extends JpaRepository<Order, String> {

@Query("select new com.mytests.spring.jpa.dateFunctionsInQueries.model.OrderIdAndAddress(tx.id, tx.address) from Order tx where month(tx.date) = month(:date) and year(tx.date) = year(:date)")
List<OrderIdAndAddress> getOrdersByDate(@Param("date") Date date);

    @Query("select d from Order d where d.status = 'placed' and d.created < current_timestamp() + :timeout")
    List<Order> processUrgently(@Param("timeout") Double timeout);


}