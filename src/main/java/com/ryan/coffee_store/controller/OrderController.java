package com.ryan.coffee_store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryan.coffee_store.DTO.OrderDTO;
import com.ryan.coffee_store.service.OrdersService;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrdersService ordersService;


    //GET
    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders(){
        return new ResponseEntity<>(ordersService.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable Integer id){
        return ordersService.getOrderById(id);
    }

    //UPDATE
    @PutMapping("/{id}")
    public OrderDTO updateOrder(@PathVariable Integer id, @RequestBody OrderDTO order){
        return ordersService.updateOrder(id, order);
    }

    //POST
    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO){
        return new ResponseEntity<>(ordersService.createOrder(orderDTO), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Integer id){
        ordersService.deleteOrder(id);
    }

}
