package com.order_service.mapper;

import com.order_service.dto.requestDto.CreateOrderItemRequestDTO;
import com.order_service.dto.responseDto.OrderItemResponseDto;
import com.order_service.entity.OrderItemEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {
    public static OrderItemEntity toEntity(CreateOrderItemRequestDTO dto){
       return OrderItemEntity.builder()
               .productId(dto.getProductId())
               .quantity(dto.getQuantity())
               .productName(dto.getProductName())
               .price(dto.getPrice())
               .subtotal(0.0)
               .build();
    }

    public OrderItemResponseDto toResponseDto(OrderItemEntity entity){
        return OrderItemResponseDto.builder()
                .subtotal(entity.getSubtotal())
                .quantity(entity.getQuantity())
                .productName(entity.getProductName())
                .productId(entity.getProductId())
                .price(entity.getPrice())
                .orderItemId(entity.getOrderItemId())
                .build();
    }
}
