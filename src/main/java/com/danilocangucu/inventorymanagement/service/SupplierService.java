package com.danilocangucu.inventorymanagement.service;

import com.danilocangucu.inventorymanagement.entity.Supplier;

import java.util.Optional;
import java.util.List;
import java.util.UUID;

public interface SupplierService {
    Supplier saveSupplier(Supplier supplier);
    Optional<Supplier> getSupplierById(UUID id);
    List<Supplier> getAllSuppliers();
    Supplier updateSupplier(Supplier supplier);
    boolean deleteSupplier(UUID id);
}
