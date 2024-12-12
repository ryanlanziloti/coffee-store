package com.ryan.coffee_store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.coffee_store.DTO.OrderDTO;
import com.ryan.coffee_store.mapper.OrderMapper;
import com.ryan.coffee_store.model.Orders;
import com.ryan.coffee_store.repository.OrdersRepository;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private OrderMapper orderMapper;

    
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
    public OrderDTO updateOrder(Integer id, OrderDTO newOrder){

        Orders order = orderMapper.toEntity(newOrder);

        order.setCustomer_name(newOrder.customer_name());
        order.setOrder_status(newOrder.order_status());
        order.setTotal_amount(newOrder.total_amount());
        
        ordersRepository.save(order);
        return orderMapper.toDto(order);

    }

    //CREATE
    public OrderDTO createOrder(OrderDTO newOrder){

        Orders orders = orderMapper.toEntity(newOrder);

        ordersRepository.save(orders);

        return newOrder;
    }

    //DELETE
    public void deleteOrder(Integer id){
        ordersRepository.deleteById(id);
    }

    /*
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
*/
}
