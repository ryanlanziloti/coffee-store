package com.ryan.coffee_store.DTO;

public record OrderItemDTO(
    Integer order_item_id,
    Integer order_id,
    Integer product_id,
    int quantity,
    int item_price
) {

    public OrderItemDTO addOrderItem(Integer order_item_id,
    Integer order_id,
    Integer product_id,
    int quantity,
    int item_price){
        return new OrderItemDTO(order_item_id, order_id, product_id, quantity, item_price);
    }

}
