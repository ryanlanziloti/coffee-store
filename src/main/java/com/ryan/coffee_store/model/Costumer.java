package com.ryan.coffee_store.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Costumer")
public class Costumer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="costumer_id")
    private Integer costumer_id;

    @Column(name = "costumer_name", nullable=false)
    private String costumer_name;

    @Column(name = "costumer_email", unique = true, nullable=false) 
    private String costumer_email;

    @Column(name = "costumer_password", unique = false, nullable=false)
    private String costumer_password;

    @OneToMany(mappedBy = "costumer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Orders> orders;
}
