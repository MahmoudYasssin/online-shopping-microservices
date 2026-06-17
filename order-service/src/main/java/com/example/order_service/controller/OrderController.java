package com.example.order_service.controller;


import com.example.order_service.dto.OrderRequest;
import com.example.order_service.dto.OrderResponse;
import com.example.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse>createOrder(@RequestBody OrderRequest orderRequest)
    {
        System.out.println(orderRequest);
        orderService.creatOrder(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new OrderResponse("201", "Product created successfully"));

    }
}
