package com.ryan.coffee_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
 
import com.ryan.coffee_store.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    @Query("SELECT o FROM Orders o WHERE o.order_id = :order_id")
    Orders findByOrderId(@Param("order_id") Integer order_id);

}
