package com.example.inventory_service.service.impl;

import com.example.inventory_service.dto.InventoryResponse;
import com.example.inventory_service.mapper.InventoryMapper;
import com.example.inventory_service.model.Inventory;
import com.example.inventory_service.repository.InventoryRepository;
import com.example.inventory_service.service.InventoryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;


    @Override
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        List<Inventory>inventories=inventoryRepository.findBySkuCodeIn(skuCode);
        return inventories.stream().map(p->InventoryMapper.mapToInventoryRes(p)).collect(Collectors.toList());

    }

    @Override
    public void addToInventory(Inventory inventory) {
        if(inventoryRepository.existsBySkuCode(inventory.getSkuCode()))
        {
            throw new IllegalArgumentException(
                    "SKU code already exists");
        }
        else
        {
            inventoryRepository.save(inventory);

        }
    }

    // هذا هو الـ Kafka Listener

}
