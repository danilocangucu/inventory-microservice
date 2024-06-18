package com.danilocangucu.inventorymanagement.service;

import com.danilocangucu.inventorymanagement.entity.Supplier;

import java.util.Optional;
import java.util.List;

public interface SupplierService {
    Supplier saveSupplier(Supplier supplier);
    Optional<Supplier> getSupplierById(Long id);
    List<Supplier> getAllSuppliers();
    Supplier updateSupplier(Supplier supplier);
    boolean deleteSupplier(Long id);
}
