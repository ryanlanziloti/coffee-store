package com.ryan.coffee_store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryan.coffee_store.model.Order_items;
import com.ryan.coffee_store.service.Order_itemsService;

@RestController
@RequestMapping("/order_items")
public class Order_itemsController {

    @Autowired
    private Order_itemsService order_itemsService;

    //GET
    @GetMapping("/{order_id}")
    public List<Order_items> getOrder_itemByOrdem_id(@PathVariable Integer order_id){
        return order_itemsService.getOrder_itemByOrdem_id(order_id);
    }

    /*/UPDATE
    @PutMapping("/{id}")
    public Order_items updateOrder_item(@PathVariable Integer id, @RequestBody Order_items order_items){
        return order_itemsService.updateOrder_item(id,order_items);
    }*/

    //CREATE
    @PostMapping("/")
    public Order_items createOrder_item(@RequestBody Order_items order_items){
        return order_itemsService.createOrder_items(order_items);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void deleteOrder_item(@PathVariable Integer id){
        order_itemsService.deleteOrder_items(id);
    }

    @DeleteMapping("/byOrder/{order_id}")
    public void deleteOrder_itemByOrder(@PathVariable Integer order_id){
        order_itemsService.deleteAllOrder_items(order_id);
    }


}