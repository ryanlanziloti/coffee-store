package com.ryan.coffee_store.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.ryan.coffee_store.DTO.OrderDTO;
import com.ryan.coffee_store.DTO.OrderItemDTO;
import com.ryan.coffee_store.model.Order_items;
import com.ryan.coffee_store.model.Orders;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDTO toDto(Orders orders);

    @Mapping(target="order_items", ignore=true)
    @Mapping(target="order_id", ignore=true)
    Orders toEntity(OrderDTO orderDTO);
 
    List<OrderDTO> toOrderDtos(List<Orders> orders);

    @Mapping(target = "order_id", source = "order.order_id")
    @Mapping(target = "product_id", source = "product.product_id")
    OrderItemDTO toOrderItemDTO(Order_items order_items);

    @Mapping(target = "order.order_id", source = "order_id")
    @Mapping(target = "product.product_id", source = "product_id")
    Order_items toOrderItemEntity(OrderItemDTO order_itemDTO);

    List<OrderItemDTO> tOrderItemDTOs(List<Order_items> order_items);

}
