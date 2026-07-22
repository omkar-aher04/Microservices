package com.order_service.service;

import com.order_service.dto.responseDto.OrderItemResponseDto;
import com.order_service.entity.OrderItemEntity;
import com.order_service.mapper.OrderItemMapper;
import com.order_service.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private OrderItemMapper orderItemMapper;
    public List<OrderItemResponseDto> getAllOrderItems() {
        return orderItemRepository.getAllOrderItems()
                .stream()
                .map(orderItemMapper::toResponseDto)
                .toList();
    }


}
