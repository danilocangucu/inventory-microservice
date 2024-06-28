package com.danilocangucu.inventorymanagement.service;

import com.danilocangucu.inventorymanagement.dto.OrderCreationDTO;
import com.danilocangucu.inventorymanagement.dto.OrderUpdateDTO;
import com.danilocangucu.inventorymanagement.entity.Order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderService {
    Order createOrder(OrderCreationDTO orderToCreate);
    Optional<Order> getOrderById(UUID orderId);
    List<Order> getAllOrders();
    Order updateOrder(UUID orderId, OrderUpdateDTO updatedOrder);
    void deleteOrder(UUID orderId);
}
