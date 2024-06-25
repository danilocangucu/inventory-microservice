package com.danilocangucu.inventorymanagement.service;

import com.danilocangucu.inventorymanagement.dto.OrderCreationDTO;
import com.danilocangucu.inventorymanagement.dto.OrderItemDTO;
import com.danilocangucu.inventorymanagement.entity.Order;
import com.danilocangucu.inventorymanagement.entity.OrderItem;
import com.danilocangucu.inventorymanagement.repository.OrderRepository;
import com.danilocangucu.inventorymanagement.repository.StockRepository;
import com.danilocangucu.inventorymanagement.util.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private OrderItemService orderItemService;

    @Override
    public Order createOrder(OrderCreationDTO orderToCreate) {
        if (orderToCreate == null || orderToCreate.getItems() == null || orderToCreate.getItems().isEmpty()) {
            throw new IllegalArgumentException("Invalid order details");
        }

        Order order = new Order();
        order.setId(UUID.randomUUID());
        order.setOrderDate(new Date());
        order.setStatus(OrderStatus.PENDING);

        Order savedOrder = orderRepository.save(order);

        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItemDTO orderItemDTO : orderToCreate.getItems()) {
            OrderItem orderItem = orderItemService.createOrderItem(orderItemDTO, savedOrder);
            orderItems.add(orderItem);
        }

        savedOrder.setOrderItems(orderItems);

        return orderRepository.save(savedOrder);
    }

    @Override
    public Optional<Order> getOrderById(UUID orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
