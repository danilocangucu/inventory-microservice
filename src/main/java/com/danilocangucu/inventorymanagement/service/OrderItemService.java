package com.danilocangucu.inventorymanagement.service;

import com.danilocangucu.inventorymanagement.dto.OrderItemDTO;
import com.danilocangucu.inventorymanagement.entity.Order;
import com.danilocangucu.inventorymanagement.entity.OrderItem;

import java.util.UUID;

public interface OrderItemService {
    OrderItem createOrderItem(OrderItemDTO orderItemDTO, Order order);
}
