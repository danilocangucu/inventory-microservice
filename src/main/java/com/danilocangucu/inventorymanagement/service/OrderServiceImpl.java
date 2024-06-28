package com.danilocangucu.inventorymanagement.service;

import com.danilocangucu.inventorymanagement.dto.OrderCreationDTO;
import com.danilocangucu.inventorymanagement.dto.OrderItemDTO;
import com.danilocangucu.inventorymanagement.dto.OrderUpdateDTO;
import com.danilocangucu.inventorymanagement.entity.Order;
import com.danilocangucu.inventorymanagement.entity.OrderItem;
import com.danilocangucu.inventorymanagement.repository.OrderRepository;
import com.danilocangucu.inventorymanagement.repository.StockRepository;
import com.danilocangucu.inventorymanagement.util.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    @Override
    public Order updateOrder(UUID orderId, OrderUpdateDTO updatedOrderDTO) {
        Optional<Order> foundOrderOptional = getOrderById(orderId);
        if (foundOrderOptional.isEmpty()) {
            throw new RuntimeException("Order not found with id: " + orderId);
        }

        Order existingOrder = foundOrderOptional.get();

        existingOrder.setStatus(updatedOrderDTO.getStatus());
        existingOrder.setOrderDate(updatedOrderDTO.getOrderDate() != null ? updatedOrderDTO.getOrderDate() : new Date());

        existingOrder.getOrderItems().clear();

        for (OrderItem dto : updatedOrderDTO.getItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setId(dto.getId());
            orderItem.setQuantity(dto.getQuantity());
            orderItem.setProductId(dto.getProductId());
            orderItem.setOrder(existingOrder);
            existingOrder.getOrderItems().add(orderItem);
        }

        return orderRepository.save(existingOrder);
    }

    @Override
    public void deleteOrder(UUID orderId) {

    }
}
