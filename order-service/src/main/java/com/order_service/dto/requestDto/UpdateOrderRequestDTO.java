package com.order_service.dto.requestDto;

import lombok.Data;

import java.util.List;

@Data
public class UpdateOrderRequestDTO {
    private String shippingAddress;
    public List<CreateOrderItemRequestDTO> items;
}
