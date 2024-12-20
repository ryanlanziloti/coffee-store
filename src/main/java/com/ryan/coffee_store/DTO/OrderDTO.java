package com.ryan.coffee_store.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.ryan.coffee_store.model.OrderStatus;

public record OrderDTO(
    Integer order_id,
    LocalDateTime order_date,
    OrderStatus order_status,
    BigDecimal total_amount,
    Integer costumer_id,
    List<OrderItemDTO> order_items
) {}
