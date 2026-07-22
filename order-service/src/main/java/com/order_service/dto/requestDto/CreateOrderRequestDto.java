package com.order_service.dto.requestDto;

import lombok.Data;

import java.util.List;


@Data

public class CreateOrderRequestDto {
    private Integer userId;
    private String shippingAddress;
    private List<CreateOrderItemRequestDTO> items;


}

