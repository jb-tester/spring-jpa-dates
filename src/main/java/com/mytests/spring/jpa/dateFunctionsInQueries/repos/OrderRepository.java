package com.mytests.spring.jpa.dateFunctionsInQueries.repos;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.mytests.spring.jpa.dateFunctionsInQueries.model.Order;
import com.mytests.spring.jpa.dateFunctionsInQueries.model.OrderIdAndAddress;
import com.mytests.spring.jpa.dateFunctionsInQueries.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; 
import org.springframework.data.repository.query.Param; 
import org.springframework.stereotype.Repository;

@Repository 
public interface OrderRepository extends JpaRepository<Order, String> {

@Query("select new com.mytests.spring.jpa.dateFunctionsInQueries.model.OrderIdAndAddress(tx.id, tx.address) from Order tx where month(tx.date) = month(:date) and year(tx.date) = year(:date)")
List<OrderIdAndAddress> getOrdersByDate(@Param("date") Date date);

    /*@Query("select d from Order d where d.status = 'placed' and d.created < current_timestamp() + :timeout") - causes errors after upgrade*/
    @Query("select d from Order d where d.status = 'placed' and d.created < current_timestamp() ")
    List<Order> processUrgently(@Param("timeout") Double timeout);

    @Query("select o from Order o where year(o.date) = 1 + year(:current)")
    List<Order> lastYearOrders(@Param("current") Date date);

    @Query("select o from Order o where day(o.date) = 1 + day(:current)")
    List<Order> nextDayOrders(@Param("current") Date date);

    @Query(value = "select * from orders o where DAY(date) = DAY(CURDATE())", nativeQuery = true)
    List<Order> testNative();

    // https://youtrack.jetbrains.com/issue/IDEA-300505
    @Query("select order from Order order where order.sum >= ?#{[0]}")
    List<Order> findOrderBySum(int sum);

    @Query("select count(*) from Order o where o.sum > 100")
    Integer countTest();

    // https://youtrack.jetbrains.com/issue/IDEA-311512
    List<Order> findAllByStatusIn(State... status);

    /*@Query("select o from Order o where month(o.date) < trunc(current_date,'month')")
    List<Order> useTrunc();*/
}