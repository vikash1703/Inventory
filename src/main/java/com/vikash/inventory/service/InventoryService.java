package com.vikash.inventory.service;


import com.vikash.inventory.dto.InventoryRequest;
import com.vikash.inventory.dto.InventoryResponse;
import com.vikash.inventory.model.Inventory;
import com.vikash.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryResponse checkStock(String skuCode) {
        Optional<Inventory> inventory = inventoryRepository.findBySkuCode(skuCode);
        return InventoryResponse.builder()
                .skuCode(skuCode)
                .isInStock(inventory.map(i -> i.getQuantity() > 0).orElse(false))
                .build();
    }

    public void addInventory(InventoryRequest request) {
        Inventory inventory = Inventory.builder()
                .skuCode(request.getSkuCode())
                .quantity(request.getQuantity())
                .build();

        inventoryRepository.save(inventory);
    }
}


