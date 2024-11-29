package com.ryan.coffee_store.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
@Table(name = "Orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer order_id;

    @Column(name = "customer_name", length = 50)
    private String customer_name;

    @Column(name = "order_date", columnDefinition = "timestamp without time zone default CURRENT_TIMESTAMP")
    private LocalDateTime order_date;

    @Column(name = "order_status", length = 20)
    private String order_status;

    @Column(name = "total_amount", precision = 10, scale = 2)
    private BigDecimal total_amount;

    @OneToMany(mappedBy = "Orders", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Order_items> order_items;
 
    public Orders(Integer order_id, String customer_name, LocalDateTime order_date, String order_status,
            BigDecimal total_amount, Set<Order_items> order_items) {
        this.order_id = order_id;
        this.customer_name = customer_name;
        this.order_date = order_date;
        this.order_status = order_status;
        this.total_amount = total_amount;
        this.order_items = order_items;
    }

    public Orders() {
        
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public LocalDateTime getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDateTime order_date) {
        this.order_date = order_date;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    public Set<Order_items> getOrder_items() {
        return order_items;
    }

    public void setOrder_items(Set<Order_items> order_items) {
        this.order_items = order_items;
    }


}
