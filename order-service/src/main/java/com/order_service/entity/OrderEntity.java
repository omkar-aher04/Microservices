package com.order_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.order_service.enums.OrderStatus;
import com.order_service.enums.PaymentStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@Table(name = "orders", uniqueConstraints = { @UniqueConstraint(columnNames = {"orderId", "userId"})})
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class OrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "orderId",nullable = false) @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    @Builder.Default
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItemEntity> items = new ArrayList<>();

    @Column(name = "userId",nullable = false)
    private Integer userId;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Column(name = "totalAmount",nullable = false)
    private Double totalAmount;

    @Column(name = "shippingAddress",nullable = false)
    private String shippingAddress;

    @Column(name = "orderDate",nullable = false)
    private LocalDate orderDate;

    @Column(name = "updatedAt",nullable = false)
    private LocalDate updatedAt;

}
