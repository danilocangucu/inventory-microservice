package com.danilocangucu.inventorymanagement.service;

import com.danilocangucu.inventorymanagement.dto.OrderItemDTO;
import com.danilocangucu.inventorymanagement.entity.Order;
import com.danilocangucu.inventorymanagement.entity.OrderItem;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderItemService {
    OrderItem createOrderItem(OrderItemDTO orderItemDTO, Order order);
    Optional<OrderItem> getOrderItemById(UUID orderItemId);
    List<OrderItem> getAllOrderItems();
    OrderItem updateOrderItem(OrderItemDTO orderItemDTO, UUID orderId);
    boolean deleteOrderItem(UUID orderItemId);
}
