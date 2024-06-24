package com.danilocangucu.inventorymanagement.service;

import com.danilocangucu.inventorymanagement.entity.Stock;
import com.danilocangucu.inventorymanagement.util.StockLevel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StockService {
    Stock saveStock(Stock stock);
    Optional<Stock> getStockById(UUID id);
    List<Stock> getAllStocks();
    Stock updateStock(Stock stock);
    boolean deleteStock(UUID id);
    List<Stock> filterStocks(UUID supplierId, UUID productId);

    StockLevel checkStockLevel(UUID productId);
}
