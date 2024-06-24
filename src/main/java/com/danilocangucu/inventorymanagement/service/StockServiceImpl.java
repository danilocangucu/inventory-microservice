package com.danilocangucu.inventorymanagement.service;

import com.danilocangucu.inventorymanagement.entity.Stock;
import com.danilocangucu.inventorymanagement.repository.StockRepository;
import com.danilocangucu.inventorymanagement.util.StockLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StockServiceImpl implements StockService {
    private static final int LOW_STOCK_LIMIT = 10;
    private static final int VERY_LOW_STOCK_LIMIT = 5;
    private static final int OUT_OF_STOCK_LIMIT = 0;

    @Autowired
    private StockRepository stockRepository;
    @Override
    public Stock saveStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Optional<Stock> getStockById(UUID id) {
        return stockRepository.findById(id);
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock updateStock(Stock stock) {
        if (stockRepository.existsById(stock.getId())) {
            return stockRepository.save(stock);
        }

        throw new RuntimeException("Stock not found with id: " + stock.getId());
    }

    @Override
    public boolean deleteStock(UUID id) {
        if (stockRepository.existsById(id)) {
            stockRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Stock> filterStocks(UUID supplierId, UUID productId) {
        if (supplierId != null && productId != null) {
            Stock foundStock = stockRepository.findBySupplierIdAndProductId(supplierId, productId);
            return foundStock != null ? List.of(foundStock) : List.of();
        } else if (supplierId != null) {
            return stockRepository.findBySupplierId(supplierId);
        } else if (productId != null) {
            return stockRepository.findByProductId(productId);
        }
        throw new IllegalArgumentException("At least one of supplierId or productId must be provided.");
    }

    @Override
    public StockLevel checkStockLevel(UUID productId) {
        int currentStockLevel = filterStocks(null, productId).size();
        if (currentStockLevel == OUT_OF_STOCK_LIMIT) {
            return StockLevel.OUT_OF_STOCK;
        } else if (currentStockLevel <= VERY_LOW_STOCK_LIMIT) {
            return StockLevel.VERY_LOW;
        } else if (currentStockLevel <= LOW_STOCK_LIMIT) {
            return StockLevel.LOW;
        }
            return StockLevel.SUFFICIENT;
    }

    @Override
    public boolean isStockAvailable(UUID productId, int requiredQuantity) {
        int currentStockLevel = filterStocks(null, productId).stream()
                .mapToInt(Stock::getQuantity)
                .sum();

        return currentStockLevel >= requiredQuantity;
    }
}
