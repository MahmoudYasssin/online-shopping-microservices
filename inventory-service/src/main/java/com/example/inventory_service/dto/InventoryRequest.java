package com.example.inventory_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class InventoryRequest {

    @NotBlank(message = "SKU code is required")
    private String skuCode;

    @NotBlank(message = "quantity code is required")
    @Positive
    private Integer quantity;
}
