package com.github.coffestore.model.DTOs;

import java.util.List;

public record OrderDTO(String  order_costumer_name, String order_date, List<OrderItemDTO> orderItems) {

}
