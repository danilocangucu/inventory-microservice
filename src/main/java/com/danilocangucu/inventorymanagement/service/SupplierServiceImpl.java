package com.danilocangucu.inventorymanagement.service;

import com.danilocangucu.inventorymanagement.entity.Supplier;
import com.danilocangucu.inventorymanagement.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;
    @Override
    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Optional<Supplier> getSupplierById(Long id) {
        return supplierRepository.findById(id);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier updateSupplier(Supplier supplier) {
        if (supplierRepository.existsById(supplier.getId())) {
            return supplierRepository.save(supplier);
        }

        throw new RuntimeException("Supplier not found with id: " + supplier.getId());
    }

    @Override
    public boolean deleteSupplier(Long id) {
        if (supplierRepository.existsById(id)) {
            supplierRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
