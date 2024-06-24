package com.danilocangucu.inventorymanagement.service;

import com.danilocangucu.inventorymanagement.dto.OrderItemDTO;
import com.danilocangucu.inventorymanagement.entity.OrderItem;
import com.danilocangucu.inventorymanagement.repository.OrderItemRepository;
import com.danilocangucu.inventorymanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private StockService stockService;
    @Override
    public OrderItem createOrderItem(UUID productId, int requiredQuantity) {
        boolean hasStock = stockService.isStockAvailable(productId, requiredQuantity);

        if (!hasStock) {
            throw new RuntimeException("Product " + productId + " is out of stock or insufficient quantity");
        }

        OrderItem orderItem = new OrderItem();
        orderItem.setId(UUID.randomUUID());
        orderItem.setProductId(productId);
        orderItem.setQuantity(requiredQuantity);

        return orderItemRepository.save(orderItem);
    }
}