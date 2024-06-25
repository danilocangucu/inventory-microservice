package com.danilocangucu.inventorymanagement.controller;

import com.danilocangucu.inventorymanagement.dto.OrderItemDTO;
import com.danilocangucu.inventorymanagement.entity.Order;
import com.danilocangucu.inventorymanagement.entity.OrderItem;
import com.danilocangucu.inventorymanagement.repository.OrderRepository;
import com.danilocangucu.inventorymanagement.service.OrderItemService;
import com.danilocangucu.inventorymanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItemDTO orderItemToCreate, @RequestParam UUID orderId) {
        System.out.println("orderId: " + orderId);

        Optional<Order> foundOrder = orderRepository.findById(orderId);

        if (foundOrder.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        OrderItem createdOrderItem = orderItemService.createOrderItem(orderItemToCreate, foundOrder.get());
        return ResponseEntity.ok(createdOrderItem);
    }

}