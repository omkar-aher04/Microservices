package com.order_service.repository;

import com.order_service.dto.responseDto.OrderResponseDto;
import com.order_service.entity.OrderEntity;
import com.order_service.repository.jpaRepository.OrderJpaRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {
    @Autowired
    private OrderJpaRepsitory orderJpaRepsitory;


    public OrderEntity createOrder (OrderEntity order){
        return orderJpaRepsitory.save(order);
    }

    public List<OrderEntity> findAll() {
        return orderJpaRepsitory.findAll();
    }

    public Optional<OrderEntity> findById(Integer id) {
        return orderJpaRepsitory.findById(id);
    }

    public OrderEntity save(OrderEntity orderEntity) {
        return orderJpaRepsitory.save(orderEntity);
    }

    public void deleteById(Integer orderId) {
        orderJpaRepsitory.deleteById(orderId);
    }
}
