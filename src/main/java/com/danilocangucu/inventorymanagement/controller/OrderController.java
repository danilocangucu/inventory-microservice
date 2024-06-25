package com.danilocangucu.inventorymanagement.controller;

import com.danilocangucu.inventorymanagement.dto.OrderCreationDTO;
import com.danilocangucu.inventorymanagement.entity.Order;
import com.danilocangucu.inventorymanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderCreationDTO orderToCreate) {
        Order createdOrder = orderService.createOrder(orderToCreate);
        return ResponseEntity.ok(createdOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable UUID id) {
        Optional<Order> foundOrder = orderService.getOrderById(id);
        return foundOrder.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
}
