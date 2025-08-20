package com.vikash.inventory.controller;

import com.vikash.inventory.dto.InventoryRequest;
import com.vikash.inventory.dto.InventoryResponse;
import com.vikash.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{skuCode}")
    public InventoryResponse checkStock(@PathVariable String skuCode) {
        return inventoryService.checkStock(skuCode);
    }

    @PostMapping
    public String addInventory(@RequestBody InventoryRequest request) {
        inventoryService.addInventory(request);
        return "Inventory added successfully";
    }
}