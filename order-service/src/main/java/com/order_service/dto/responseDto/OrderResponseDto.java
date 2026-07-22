package com.order_service.dto.responseDto;

import com.order_service.entity.OrderEntity;
import com.order_service.entity.OrderItemEntity;
import com.order_service.enums.OrderStatus;
import com.order_service.enums.PaymentStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class OrderResponseDto {
    private Integer userId;
    private Integer orderId;
    private OrderStatus orderStatus;


    private PaymentStatus paymentStatus;
    private Double totalAmount;

    private String shippingAddress;

    private LocalDate orderDate;
    private LocalDate updatedAt;

    private List<OrderItemResponseDto> items;
}
