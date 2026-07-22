package com.order_service.controller;

import com.order_service.dto.requestDto.CreateOrderRequestDto;
import com.order_service.dto.requestDto.UpdateOrderRequestDTO;
import com.order_service.dto.responseDto.OrderItemResponseDto;
import com.order_service.dto.responseDto.OrderResponseDto;
import com.order_service.entity.OrderEntity;
import com.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
     private OrderService orderService;

    @GetMapping("/orders")
    public List<OrderResponseDto> getAllOrders(){
       return orderService.getAllOrders();
    }
    @GetMapping("/orders/{id}")
    public OrderResponseDto getOrderById( @PathVariable Integer id){
        return orderService.getOrderById(id);
    }
    @PostMapping("/orders")
    public OrderResponseDto addOrder(@RequestBody CreateOrderRequestDto createOrderRequestDto) {
        return orderService.addOrder(createOrderRequestDto);
    }
    @PutMapping("/orders/{id}")
    public OrderResponseDto updateOrder(@RequestBody UpdateOrderRequestDTO updateOrderRequestDTO,
                                   @PathVariable Integer id) {
        return orderService.updateOrder(updateOrderRequestDTO, id);
    }
//    //  PUT/orders/{id}/status
    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity<String> deleteOrder(
            @PathVariable Integer orderId){
         orderService.deleteOrder(orderId);
         return ResponseEntity.noContent().build();
    }
}
