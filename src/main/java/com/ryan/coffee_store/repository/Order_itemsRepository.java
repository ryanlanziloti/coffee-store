package com.ryan.coffee_store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ryan.coffee_store.model.Order_items;

@Repository
public interface Order_itemsRepository extends JpaRepository<Order_items, Integer>{

    @Modifying
    @Query("DELETE FROM Order_items o WHERE o.orders.order_id = :order_id")
    void deleteByOrderId(@Param("order_id") Integer order_id);
 
    @Query("SELECT o FROM Order_items o WHERE o.orders.order_id = :order_id")
    List<Order_items> findByOrderId(@Param("order_id") Integer order_id);

}
