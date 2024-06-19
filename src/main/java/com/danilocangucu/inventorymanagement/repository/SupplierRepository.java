package com.danilocangucu.inventorymanagement.repository;

import com.danilocangucu.inventorymanagement.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SupplierRepository extends JpaRepository<Supplier, UUID> {
}
