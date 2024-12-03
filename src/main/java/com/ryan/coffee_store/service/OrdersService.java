package com.ryan.coffee_store.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.coffee_store.model.Orders;
import com.ryan.coffee_store.repository.OrdersRepository;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    //GET
    public List<Orders> getAllOrders(){
        return ordersRepository.findAll();
    }

    public Orders getOrderById(Integer id){
        return ordersRepository.findById(id)
                                .orElseThrow(() -> new NoSuchElementException("No order founded"));
    }

    //UPDATE
    public Orders updateOrder(Integer id, Orders newOrder){

        Orders order = getOrderById(id);

        order.setCustomer_name(newOrder.getCustomer_name());
        order.setOrder_items(newOrder.getOrder_items());
        order.setOrder_status(newOrder.getOrder_status());
        order.setTotal_amount(newOrder.getTotal_amount());
        
        return ordersRepository.save(order);
    }

    //CREATE
    public Orders createOrder(Orders order){
        return ordersRepository.save(order);
    }

    //DELETE
    public void deleteOrder(Integer id){
        ordersRepository.deleteById(id);
    }

}
