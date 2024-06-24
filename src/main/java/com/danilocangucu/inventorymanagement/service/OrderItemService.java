package com.danilocangucu.inventorymanagement.service;

import com.danilocangucu.inventorymanagement.entity.OrderItem;

import java.util.UUID;

public interface OrderItemService {
    OrderItem createOrderItem(UUID productId, int requiredQuantity);
}
