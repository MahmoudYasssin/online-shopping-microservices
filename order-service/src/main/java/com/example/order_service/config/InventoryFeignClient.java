package com.example.order_service.config;

import com.example.order_service.dto.InventoryResponse;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="inventory-service")
public interface InventoryFeignClient {


    @GetMapping("/api/inventory")
    List<InventoryResponse> isInStock(@RequestParam List<String>  skuCode);


}
