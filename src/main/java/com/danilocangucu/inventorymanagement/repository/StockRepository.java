package com.danilocangucu.inventorymanagement.repository;

import com.danilocangucu.inventorymanagement.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import java.util.List;

public interface StockRepository extends JpaRepository<Stock, UUID> {
    List<Stock> findBySupplierId(UUID supplierId);
    List<Stock> findByProductId(UUID productId);
    Stock findBySupplierIdAndProductId(UUID supplierId, UUID productId);

}
