package com.ryan.coffee_store.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employees {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employee_id;

    @Column(name = "employee_name",length=50)
    private String employee_name;
    
    @Column(name = "employee_role",length=50)
    private String employee_role;

    @Column(name = "hire_date", columnDefinition = "timestamp without time zone default CURRENT_TIMESTAMP")
    private LocalDateTime hire_date;

    public Employees(Integer employee_id, String employee_name, String employee_role, LocalDateTime hire_date) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_role = employee_role;
        this.hire_date = hire_date;
    }

    public Employees() {
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_role() {
        return employee_role;
    }

    public void setEmployee_role(String employee_role) {
        this.employee_role = employee_role;
    }

    public LocalDateTime getHire_date() {
        return hire_date;
    }

    public void setHire_date(LocalDateTime hire_date) {
        this.hire_date = hire_date;
    }
}
