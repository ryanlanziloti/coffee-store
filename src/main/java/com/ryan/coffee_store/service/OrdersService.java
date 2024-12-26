package com.ryan.coffee_store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.coffee_store.DTO.OrderDTO;
import com.ryan.coffee_store.DTO.OrderItemDTO;
import com.ryan.coffee_store.mapper.OrderMapper;
import com.ryan.coffee_store.model.Orders;
import com.ryan.coffee_store.repository.OrdersRepository;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private Order_itemsService order_itemsService;

    
    //GET
    public List<OrderDTO> getAllOrders(){

        List<Orders> orders = ordersRepository.findAll();

        return orders.stream().map(order -> orderMapper.toDto(order)).toList();
    }

    public OrderDTO getOrderById(Integer id){

        Orders orders = ordersRepository.findByOrderId(id);
        
        return orderMapper.toDto(orders);

    }

    //UPDATE
    public OrderDTO updateOrder(Integer id, OrderDTO newOrder, OrderDTO oldOrder){

        Orders order = orderMapper.toEntity(oldOrder);
 
        order.setOrder_status(newOrder.order_status());
        order.setTotal_amount(newOrder.total_amount());
        //order.getOrder_items().clear();

        for(OrderItemDTO i: newOrder.order_items()){ 
            OrderItemDTO a = i.addOrderItem(i.order_item_id(),id, i.product_id(), i.quantity(), i.item_price());
            order_itemsService.createOrderItem(a);
        }
        
        ordersRepository.save(order);
        return orderMapper.toDto(order);

    }

    //CREATE
    public OrderDTO createOrder(OrderDTO newOrder){

        Orders orders = orderMapper.toEntity(newOrder);

        ordersRepository.save(orders);

        for(OrderItemDTO i: newOrder.order_items()){ 
            OrderItemDTO a = i.addOrderItem(i.order_item_id(),orders.getOrder_id(), i.product_id(), i.quantity(), i.item_price());
            order_itemsService.createOrderItem(a);
        }

        return newOrder;
    }

    //DELETE
    public void deleteOrder(Integer id){
        ordersRepository.deleteById(id);
    }
 
}
