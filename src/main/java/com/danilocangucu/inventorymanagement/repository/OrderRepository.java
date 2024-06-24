package com.danilocangucu.inventorymanagement.repository;

import com.danilocangucu.inventorymanagement.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
