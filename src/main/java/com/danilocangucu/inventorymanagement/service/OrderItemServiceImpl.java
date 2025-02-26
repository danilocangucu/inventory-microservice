package com.danilocangucu.inventorymanagement.service;

import com.danilocangucu.inventorymanagement.dto.OrderItemDTO;
import com.danilocangucu.inventorymanagement.entity.Order;
import com.danilocangucu.inventorymanagement.entity.OrderItem;
import com.danilocangucu.inventorymanagement.repository.OrderItemRepository;
import com.danilocangucu.inventorymanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private StockService stockService;

    @Override
    public OrderItem createOrderItem(OrderItemDTO orderItemDTO, Order order) {
        UUID productId = orderItemDTO.getProductId();
        int requiredQuantity = orderItemDTO.getQuantity();

        boolean hasStock = stockService.isStockAvailable(productId, requiredQuantity);

        if (!hasStock) {
            throw new RuntimeException("Product " + productId + " is out of stock or insufficient quantity");
        }

        OrderItem orderItem = new OrderItem();
        orderItem.setId(UUID.randomUUID());
        orderItem.setProductId(productId);
        orderItem.setQuantity(requiredQuantity);
        orderItem.setOrder(order);

        return orderItemRepository.save(orderItem);
    }

    @Override
    public Optional<OrderItem> getOrderItemById(UUID orderItemId) {
        return orderItemRepository.findById(orderItemId);
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem updateOrderItem(OrderItemDTO orderItemDTO, UUID orderId) {
        Optional<OrderItem> possibleOrderItem = getOrderItemById(orderId);
        if (possibleOrderItem.isEmpty()) {
            throw new RuntimeException("OrderItem not found with id: " + orderId);
        }

        OrderItem orderItemToUpdate = possibleOrderItem.get();
        orderItemToUpdate.setQuantity(orderItemDTO.getQuantity());
        orderItemToUpdate.setProductId(orderItemDTO.getProductId());
        return orderItemRepository.save(orderItemToUpdate);
    }

    @Override
    public boolean deleteOrderItem(UUID orderItemId) {
        if (orderItemRepository.existsById(orderItemId)) {
            orderItemRepository.deleteById(orderItemId);
            return true;
        } else {
            return false;
        }
    }
}
