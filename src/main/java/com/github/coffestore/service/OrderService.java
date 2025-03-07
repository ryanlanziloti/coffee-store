package com.github.coffestore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.coffestore.model.Order;
import com.github.coffestore.repository.OrderRepository;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    //FIND ALL ORDERS
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    //FIND ORDER BY ID
    public Order findOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    //CREATE ORDER
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    //UPDATE ORDER
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    //DELETE ORDER
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
