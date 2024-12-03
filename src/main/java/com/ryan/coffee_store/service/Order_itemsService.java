package com.ryan.coffee_store.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.coffee_store.model.Order_items;
import com.ryan.coffee_store.repository.Order_itemsRepository;

@Service
public class Order_itemsService {

    @Autowired
    private Order_itemsRepository order_itemsRepository;

    //GET
    public List<Order_items> getAllOrder_items(){
        return order_itemsRepository.findAll();
    }

    public Order_items getOrder_itemById(Integer id){
        return order_itemsRepository.findById(id)
                                    .orElseThrow(() -> new NoSuchElementException("No order item founded")); 
    }

    public List<Order_items> getOrder_itemByOrdem_id(Integer id){
        return order_itemsRepository.findByOrderId(id);
    }

    /*/UPDATE
    public Order_items updateOrder_item(Integer id, Order_items newOrder_item){

        Order_items order_items = getOrder_itemById(id);

        order_items.set

        return order_itemsRepository.save(order_items);
    }*/

    //CREATE
    public Order_items createOrder_items(Order_items order_items){
        return order_itemsRepository.save(order_items);
    }
    
    //DELETE
    public void deleteOrder_items(Integer id){
        order_itemsRepository.deleteById(id);
    }

    public void deleteAllOrder_items(Integer order_id){
        order_itemsRepository.deleteByOrderId(order_id);
    }

}
