package com.ryan.coffee_store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.coffee_store.DTO.CostumerDTO;
import com.ryan.coffee_store.mapper.CostumerMapper;
import com.ryan.coffee_store.model.Costumer;
import com.ryan.coffee_store.repository.CostumerRepository;

@Service
public class CostumerService {

    @Autowired
    private CostumerRepository costumerRepository;

    @Autowired
    private CostumerMapper costumerMapper;

    //GET
    public List<CostumerDTO> getAllCostumer(){
        List<Costumer> costumer = costumerRepository.findAll();
        return costumer.stream().map(costumers -> costumerMapper.toDto(costumers)).toList();
    }

    public CostumerDTO getCostumerById(Integer id){
        Costumer costumer = costumerRepository.findByCostumerId(id);

        return costumerMapper.toDto(costumer);
    }

     
    //UPDATE
    public CostumerDTO editCostumer(Integer id, CostumerDTO newCostumer){ 

        Costumer costumer = costumerMapper.toEntity(getCostumerById(id));
        
        costumer.setCostumer_name(newCostumer.costumer_name());
        costumer.setCostumer_email(newCostumer.costumer_email());
        costumer.setCostumer_password(newCostumer.costumer_password());

        costumerRepository.save(costumer); 

        return costumerMapper.toDto(costumer);
    }

    //CREATE
    public CostumerDTO createCostumer(CostumerDTO newCostumer){
        Costumer costumer = costumerMapper.toEntity(newCostumer);

        costumerRepository.save(costumer);

        return newCostumer;
    }

    //DELETE
    public void deleteCostumer(Integer id){
        costumerRepository.deleteById(id); 
    } 

}
