package com.vikash.inventory.repository;


import com.vikash.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface InventoryRepository extends JpaRepository<Inventory, UUID> {
    Optional<Inventory> findBySkuCode(String skuCode);
}
