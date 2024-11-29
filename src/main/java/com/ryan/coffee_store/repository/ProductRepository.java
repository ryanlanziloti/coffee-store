package com.ryan.coffee_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ryan.coffee_store.model.Product;

@Repository
public interface ProductRepository extends  JpaRepository<Product, Integer> {

}
