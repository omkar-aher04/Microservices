package com.order_service.dto.requestDto;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderItemRequestDTO {
    private Integer productId;
    private String productName;
    private double price;
    private Integer quantity;
}
