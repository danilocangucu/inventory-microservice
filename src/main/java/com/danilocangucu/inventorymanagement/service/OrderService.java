package com.danilocangucu.inventorymanagement.service;

import com.danilocangucu.inventorymanagement.dto.OrderCreationDTO;
import com.danilocangucu.inventorymanagement.entity.Order;

public interface OrderService {
    Order createOrder(OrderCreationDTO orderToCreate);
}
