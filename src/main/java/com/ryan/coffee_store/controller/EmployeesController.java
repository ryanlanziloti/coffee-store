package com.ryan.coffee_store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryan.coffee_store.model.Employees;
import com.ryan.coffee_store.service.EmployeesService;

@RestController
@RequestMapping("/employee")
public class EmployeesController {

    @Autowired
    private EmployeesService employeesService;

    //GET
    @GetMapping("/")
    public List<Employees> getAllEmployees(){
        return employeesService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employees getEmployeesById(@PathVariable Integer id){
        return employeesService.getEmployeesById(id);
    }

    //UPDATE
    @PutMapping("/{id}")
    public Employees updatEmployees(@PathVariable Integer id, @RequestBody Employees employees){
        return employeesService.updateEmployees(id, employees);
    }

    //CREATE
    @PostMapping("/")
    public Employees createEmployee(@RequestBody Employees employee){
        return employeesService.creatEmployees(employee);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id){
        employeesService.deleteEmployees(id);
    }

}
