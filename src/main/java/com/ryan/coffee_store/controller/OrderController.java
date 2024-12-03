package com.ryan.coffee_store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryan.coffee_store.service.OrdersService;

import com.ryan.coffee_store.model.Orders;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrdersService ordersService;

    //GET
    @GetMapping
    public List<Orders> getAllOrders(){
        return ordersService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable Integer id){
        return ordersService.getOrderById(id);
    }

    //UPDATE
    @PutMapping("/{id}")
    public Orders updateOrder(@PathVariable Integer id, @RequestBody Orders order){
        return ordersService.updateOrder(id, order);
    }

    //CREATE
    @PostMapping
    public Orders createorder(@RequestBody Orders order){
        return ordersService.createOrder(order);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Integer id){
        ordersService.deleteOrder(id);
    }

}
