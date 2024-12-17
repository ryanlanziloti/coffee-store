package com.ryan.coffee_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ryan.coffee_store.model.Costumer;

@Repository
public interface CostumerRepository extends JpaRepository<Costumer, Integer> {

    @Query("SELECT c FROM Costumer c WHERE c.costumer_id = :costumer_id")
    Costumer findByCostumerId(@Param("costumer_id") Integer costumer_id);

}
