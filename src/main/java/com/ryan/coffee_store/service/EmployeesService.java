package com.ryan.coffee_store.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.ryan.coffee_store.model.Employees;
import com.ryan.coffee_store.repository.EmployeesRepository;

@Service
public class EmployeesService {
 
    private EmployeesRepository employeesRepository;

    //GET
    public List<Employees> getAllEmployees(){
        return employeesRepository.findAll();
    }

    public Employees getEmployeesById(Integer id){
        return employeesRepository.findById(id)
                                  .orElseThrow(() -> new NoSuchElementException("No order item founded")); 
    }

    //UPDATE
    public Employees updateEmployees(Integer id, Employees newEmployees){

        Employees employees = getEmployeesById(id);
        
        employees.setEmployee_name(newEmployees.getEmployee_name());
        employees.setEmployee_role(newEmployees.getEmployee_role());
        employees.setEmployee_password(newEmployees.getEmployee_password()); 

        return employeesRepository.save(employees);
    }

    //CREATE
    public Employees creatEmployees(Employees employees){
        return employeesRepository.save(employees);
    }

    //DELETE
    public void deleteEmployees(Integer id){
        employeesRepository.deleteById(id);
    }

}
