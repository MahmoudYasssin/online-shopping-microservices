package com.example.order_service.mapper;

import com.example.order_service.dto.OrderLineItemsDto;
import com.example.order_service.dto.OrderRequest;
import com.example.order_service.model.Order;
import com.example.order_service.model.OrderLineItems;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class OrderMapper {

    public static Order mapToOrder(OrderRequest orderRequest) {

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        System.out.println(orderRequest);


        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtos()
                .stream()
                .map(OrderMapper::mapToOrderLineItems)
                .collect(Collectors.toList());

        System.out.println(orderLineItems);

       order.setOrderLineItems(orderLineItems);

        return order;
    }

    public static OrderLineItems mapToOrderLineItems(OrderLineItemsDto dto) {

        OrderLineItems orderLineItems = new OrderLineItems();

        orderLineItems.setQuantity(dto.getQuantity());
        orderLineItems.setPrice(dto.getPrice());
        orderLineItems.setSkuCode(dto.getSkuCode());

        return orderLineItems;
    }
}