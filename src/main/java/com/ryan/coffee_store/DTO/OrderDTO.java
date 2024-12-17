package com.ryan.coffee_store.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public record OrderDTO(
    Integer order_id,
    LocalDateTime order_date,
    String order_status,
    BigDecimal total_amount,
    Integer costumer_id,
    Set<OrderItemDTO> order_items
) {}
