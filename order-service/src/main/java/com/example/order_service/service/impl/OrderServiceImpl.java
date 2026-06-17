package com.example.order_service.service.impl;

import com.example.order_service.config.InventoryFeignClient;
import com.example.order_service.dto.InventoryResponse;
import com.example.order_service.dto.OrderRequest;
import com.example.order_service.dto.OrderLineItemsDto;
import com.example.order_service.mapper.OrderMapper;
import com.example.order_service.model.Order;
import com.example.order_service.repository.OrderRepository;
import com.example.order_service.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private static final String TOPIC = "order-created-topic";


    private final OrderRepository orderRepository;
    private final InventoryFeignClient inventoryFeignClient;
    private final KafkaTemplate kafkaTemplate;

    //inventory-->Circuit Breaker instance name.
    @CircuitBreaker(
            name = "inventory",
            fallbackMethod = "inventoryFallback"
    )
    @Override
    public void creatOrder(OrderRequest orderRequest) {

        Map<String,Integer>skuCode_Quntity = new HashMap<>();
        List<String>skuCodes = new ArrayList<>();
      for(OrderLineItemsDto  item:orderRequest.getOrderLineItemsDtos())
      {

          skuCode_Quntity.put(item.getSkuCode(),item.getQuantity());
          skuCodes.add(item.getSkuCode());
      }
        List<InventoryResponse> inventoryResponse = inventoryFeignClient.isInStock(skuCodes);



      for(InventoryResponse inventoryResponse1:inventoryResponse)
      {
          if(skuCode_Quntity.get(inventoryResponse1.getSkuCode())>inventoryResponse1.getQuantity())
          {

              throw new IllegalArgumentException(
                      "Not enough stock for "
                              + inventoryResponse1.getSkuCode());
          }
          else
          {
              Order order= OrderMapper.mapToOrder(orderRequest);
              orderRepository.save(order);
              kafkaTemplate.send(TOPIC, "customer-1", order.getOrderNumber());
              System.out.println(order.getOrderNumber());


          }
      }
    }
    /*
    Resilience4J requires the fallback method to have the same parameters as the original method.
     ex --> Resilience4J passes the exception that caused the failure.
     */
    public List<InventoryResponse> inventoryFallback(
            OrderRequest orderRequest,
            Exception ex) {

        System.out.println("Inventory Service is unavailable");

        throw new RuntimeException(
                "Inventory Service is currently unavailable");
    }
}
