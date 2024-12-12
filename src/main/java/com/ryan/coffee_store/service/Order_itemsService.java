package com.ryan.coffee_store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.coffee_store.DTO.OrderItemDTO;
import com.ryan.coffee_store.mapper.OrderMapper;
import com.ryan.coffee_store.model.Order_items;
import com.ryan.coffee_store.repository.Order_itemsRepository;

@Service
public class Order_itemsService {

    @Autowired
    private Order_itemsRepository order_itemsRepository;

    @Autowired
    private OrderMapper orderMapper;

    //GET
    public List<OrderItemDTO> getAllOrderItem(){

        List<Order_items> order_items = order_itemsRepository.findAll();

        return order_items.stream().map(order_item -> orderMapper.toOrderItemDTO(order_item)).toList();
    }

    public OrderItemDTO getOrderItemById(Integer id){
        Order_items order_items = order_itemsRepository.findByOrderItemId(id);

        return orderMapper.toOrderItemDTO(order_items); 
    }

    //UPDATE
    public OrderItemDTO updateOrder_item(Integer id, OrderItemDTO newOrder_item){

        Order_items order_item = OrderMapper.INSTANCE.toOrderItemEntity(newOrder_item);

        order_item.setItem_price(newOrder_item.item_price());
        order_item.setQuantity(newOrder_item.quantity());

        order_itemsRepository.save(order_item);
        return newOrder_item;
    }

    //CREATE
    public OrderItemDTO createOrderItem(OrderItemDTO newOrderItem){

        Order_items order_items = orderMapper.toOrderItemEntity(newOrderItem);

        order_itemsRepository.save(order_items);

        return newOrderItem;
    }

    //DELETE
    public void deleteOrder_items(Integer id){
        order_itemsRepository.deleteById(id);
    }

    public void deleteAllOrder_items(Integer order_id){
        order_itemsRepository.deleteByOrderId(order_id);
    }

    /*
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

    //UPDATE
    public Order_items updateOrder_item(Integer id, Order_items newOrder_item){

        Order_items order_items = getOrder_itemById(id);

        order_items.set

        return order_itemsRepository.save(order_items);
    }
    
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
    */
    
}
