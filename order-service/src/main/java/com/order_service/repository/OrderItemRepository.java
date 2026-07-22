package com.order_service.repository;

import com.order_service.entity.OrderItemEntity;
import com.order_service.repository.jpaRepository.OrderItemJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderItemRepository {
    @Autowired
    private OrderItemJpaRepository orderItemJpaRepository;

    public List<OrderItemEntity> getAllOrderItems( ) {
        return orderItemJpaRepository.findAll();
    }


}
