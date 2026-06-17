package com.example.inventory_service.mapper;

import com.example.inventory_service.dto.InventoryRequest;
import com.example.inventory_service.dto.InventoryResponse;
import com.example.inventory_service.model.Inventory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data

public class InventoryMapper {

    public static Inventory mapToInventory(InventoryRequest inventoryRequest)
    {
        Inventory inventory=new Inventory();
        inventory.setQuantity(inventoryRequest.getQuantity());
        inventory.setSkuCode(inventoryRequest.getSkuCode());
        return inventory;
    }

    public static InventoryResponse mapToInventoryRes(Inventory inventory)
    {
        InventoryResponse inventoryResponse=new InventoryResponse();
        inventoryResponse.setQuantity(inventory.getQuantity());
        inventoryResponse.setSkuCode(inventory.getSkuCode());
        return inventoryResponse;
    }

}
