package com.github.coffestore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*; 

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @Column(name = "product_name", nullable = false, length = 50)
    private String product_name;

    @Column(name = "product_price", nullable = false)
    private double product_price;
    
    @Column(name = "product_description", nullable = false, length = 100)
    private String product_description;

    @Column(name = "product_active", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE", length = 4)
    private boolean product_active; 
    
}
