package com.vikash.inventory.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryRequest {
    private String skuCode;
    private int quantity;
}
