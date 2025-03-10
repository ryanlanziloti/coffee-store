package com.github.coffestore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.coffestore.model.OrderItem;
import com.github.coffestore.repository.OrderItemRepository;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    //GET
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItem getOrderItemById(Long id){
        return orderItemRepository.findById(id).orElse(null);
    }
 
    public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
        return orderItemRepository.findByOrder_id(orderId);
    }

    //POST
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    //PUT
    public OrderItem updateOrderItem(Long id, OrderItem orderItem) {
        OrderItem existingOrderItem = orderItemRepository.findById(id).orElse(null);
        if (existingOrderItem != null) {
            existingOrderItem.setProduct_id(orderItem.getProduct_id());
            existingOrderItem.setQuantity(orderItem.getQuantity());
            return orderItemRepository.save(existingOrderItem);
        }
        return null;
    }

    //DELETE
    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}
