package com.order_service.mapper;

import com.order_service.dto.requestDto.CreateOrderRequestDto;
import com.order_service.dto.responseDto.OrderItemResponseDto;
import com.order_service.dto.responseDto.OrderResponseDto;
import com.order_service.entity.OrderEntity;
import com.order_service.entity.OrderItemEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderMapper {
    private final OrderItemMapper orderItemMapper;

    public OrderMapper(OrderItemMapper orderItemMapper) {
        this.orderItemMapper = orderItemMapper;
    }
    public OrderEntity toEntity(CreateOrderRequestDto dto){
        OrderEntity order =  OrderEntity.builder()
                .userId(dto.getUserId())
                .shippingAddress(dto.getShippingAddress())
                .build();
        List<OrderItemEntity> items = dto.getItems().stream()
                .map(OrderItemMapper::toEntity)
                .toList();

        // Connect both sides of the relationship
        items.forEach(item -> item.setOrder(order));

        order.setItems(items);

        return order;
    }
    public OrderResponseDto toResponseDto(OrderEntity entity) {

        List<OrderItemResponseDto> items = entity.getItems()
                .stream()
                .map(orderItemMapper::toResponseDto)
                .toList();

        return OrderResponseDto.builder()
                .orderId(entity.getOrderId())
                .userId(entity.getUserId())
                .orderStatus(entity.getOrderStatus())
                .paymentStatus(entity.getPaymentStatus())
                .totalAmount(entity.getTotalAmount())
                .shippingAddress(entity.getShippingAddress())
                .orderDate(entity.getOrderDate())
                .updatedAt(entity.getUpdatedAt())
                .items(items)    // <-- This was missing
                .build();
    }
}
