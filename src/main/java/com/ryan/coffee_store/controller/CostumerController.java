package com.ryan.coffee_store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryan.coffee_store.DTO.CostumerDTO;
import com.ryan.coffee_store.service.CostumerService;

@RestController
@RequestMapping("/costumer")
public class CostumerController {

    @Autowired
    private CostumerService costumerService;

    //GET
    @GetMapping
    public List<CostumerDTO> getAllCostumers(){
        return costumerService.getAllCostumer();
    }

    @GetMapping("/{id}")
    public CostumerDTO getCostumerById(@PathVariable Integer id){
        return costumerService.getCostumerById(id);
    }

    //UPDATE
    @PutMapping("/{id}")
    public CostumerDTO editCostumer(@PathVariable Integer id,@RequestBody CostumerDTO costumer){
        return costumerService.editCostumer(id,costumer);
    }

    //CREATE
    @PostMapping
    public ResponseEntity<String> createCostumer(@RequestBody CostumerDTO newCostumer){
        if(isValidEmail(newCostumer.costumer_email())){
            costumerService.createCostumer(newCostumer);
        } else{
            return ResponseEntity.badRequest().body("Invalid Email");
        }
        return ResponseEntity.ok("Success"); 
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void deleteCostumer(@PathVariable Integer id){
        costumerService.deleteCostumer(id);
    }

    //SERVICE RULES
    @SuppressWarnings("empty-statement")
    private boolean isValidEmail(String email){
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}
