package com.ryan.coffee_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ryan.coffee_store.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}
