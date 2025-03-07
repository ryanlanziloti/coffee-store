package com.github.coffestore.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    @Column(name = "costumer_name", nullable = false, length = 50)
    private String order_costumer_name;

    @Column(name = "order_date", columnDefinition = "timestamp without time zone default CURRENT_TIMESTAMP")
    private LocalDateTime order_date;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

}
