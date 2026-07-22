package com.order_service.controller;

import com.order_service.dto.responseDto.OrderItemResponseDto;
import com.order_service.entity.OrderItemEntity;
import com.order_service.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")

public class OrderItemController {
    // GET, POST, PUT, DELETE
    // getAllOrderItems, getOrderById,productId,quantity,subtotal,productName
    @Autowired
    private OrderItemService orderItemService;
    private OrderItemEntity orderItemEntity;
    //get all products
    @GetMapping("/order-items")
    public List<OrderItemResponseDto> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }
}
