package com.ryan.coffee_store.model;

import java.math.BigDecimal;
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

@Entity
@Table(name="Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer product_id;

    @Column(name = "product_name",length = 100)
    private String product_name;

    @Column(name = "product_description",columnDefinition = "TEXT")
    private String product_description;

    @Column(name = "product_price", precision = 10, scale = 2)
    private BigDecimal product_price;

    @Column(name = "stock_quantity")
    private int stock_quantity;

    @OneToMany(mappedBy = "Product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Order_items> order_items;

    public Product(Integer product_id, String product_name, String product_description, BigDecimal product_price,
            int stock_quantity) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.product_price = product_price;
        this.stock_quantity = stock_quantity;
    }

    public Product() {

    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public BigDecimal getProduct_price() {
        return product_price;
    }

    public void setProduct_price(BigDecimal product_price) {
        this.product_price = product_price;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public Set<Order_items> getOrder_items() {
        return order_items;
    }

    public void setOrder_items(Set<Order_items> order_items) {
        this.order_items = order_items;
    }

    
}