package com.order_service.repository.jpaRepository;

import com.order_service.dto.responseDto.OrderResponseDto;
import com.order_service.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepsitory extends JpaRepository<OrderEntity,Integer> {



}

