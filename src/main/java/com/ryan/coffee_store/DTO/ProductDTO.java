package com.ryan.coffee_store.DTO;

import java.math.BigDecimal;

public record ProductDTO(
    Integer product_id,
    String product_name,
    String product_description,
    BigDecimal product_price,
    int stock_quantity
) {}
