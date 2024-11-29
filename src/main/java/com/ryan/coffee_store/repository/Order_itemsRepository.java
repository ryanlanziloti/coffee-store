package com.ryan.coffee_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ryan.coffee_store.model.Order_items;

@Repository
public interface Order_itemsRepository extends JpaRepository<Order_items, Integer>{

}
