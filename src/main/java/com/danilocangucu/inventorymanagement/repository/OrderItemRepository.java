package com.danilocangucu.inventorymanagement.repository;

import com.danilocangucu.inventorymanagement.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {
}
