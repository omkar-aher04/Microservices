package com.order_service.dto.responseDto;

import com.order_service.entity.OrderItemEntity;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@Builder
public class OrderItemResponseDto {

    private Double subtotal;
    private Integer quantity;
    private String productName;
    private Integer productId;
    private Integer orderItemId;
    private double price;

}
