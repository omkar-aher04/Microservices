package com.order_service.service;

import com.order_service.calculator.PriceCalculator;
import com.order_service.dto.requestDto.CreateOrderRequestDto;
import com.order_service.dto.requestDto.UpdateOrderRequestDTO;
import com.order_service.dto.responseDto.OrderItemResponseDto;
import com.order_service.dto.responseDto.OrderResponseDto;
import com.order_service.entity.OrderEntity;
import com.order_service.entity.OrderItemEntity;
import com.order_service.enums.OrderStatus;
import com.order_service.enums.PaymentStatus;
import com.order_service.mapper.OrderItemMapper;
import com.order_service.mapper.OrderMapper;
import com.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    private final PriceCalculator priceCalculator;
    @Autowired
    private OrderMapper orderMapper;

    public OrderService(PriceCalculator priceCalculator) {
        this.priceCalculator = priceCalculator;
    }
    public OrderEntity createOrder(OrderEntity order) {

        priceCalculator.calculateOrder(order);

        return orderRepository.save(order);
    }

    public List<OrderResponseDto> getAllOrders() {
        List<OrderEntity> orders = orderRepository.findAll();

        return orders.stream()
                .map(orderMapper::toResponseDto)
                .toList();
    }
    public OrderResponseDto getOrderById( Integer id){
        OrderEntity order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        return orderMapper.toResponseDto(order);
    }

    public OrderResponseDto addOrder(CreateOrderRequestDto dto) {

        OrderEntity entity = orderMapper.toEntity(dto);

        entity.setOrderDate(LocalDate.now());
        entity.setUpdatedAt(LocalDate.now());
        entity.setOrderStatus(OrderStatus.PENDING);
        entity.setPaymentStatus(PaymentStatus.PENDING);

        // Calculate totalAmount here if needed
        // entity.setTotalAmount(...);
        // Temporary value until calculation is implemented
        priceCalculator.calculateOrder(entity);
        System.out.println(entity.getTotalAmount());

        entity.getItems().forEach(item ->
                System.out.println(item.getSubtotal())
        );
        OrderEntity saved = orderRepository.save(entity);
        return orderMapper.toResponseDto(saved);
    }

    public OrderResponseDto updateOrder(UpdateOrderRequestDTO dto, Integer id) {
        OrderEntity existingOrder = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("order not found"));
        existingOrder.setShippingAddress(dto.getShippingAddress());

        existingOrder.setUpdatedAt(LocalDate.now());
        existingOrder.getItems().clear();
        List<OrderItemEntity> updatedItems = dto.getItems()
                .stream()
                .map(OrderItemMapper::toEntity)
                .toList();
        // Connect relationship
        updatedItems.forEach(item -> item.setOrder(existingOrder));
        existingOrder.getItems().addAll(updatedItems);
        existingOrder.setUpdatedAt(LocalDate.now());
        OrderEntity updatedOrder = orderRepository.save(existingOrder);

        return orderMapper.toResponseDto(updatedOrder);

    }

    public void deleteOrder(Integer orderId) {
        orderRepository.deleteById(orderId);
    }



    /*POST   /orders GET    /orders GET    /orders/{id} PUT    /orders/{id}/status
    DELETE /orders/{id}  GET/orders/user/{userId}*\ */
}
