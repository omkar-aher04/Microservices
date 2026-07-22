package com.order_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity

@Getter
@Setter
@NoArgsConstructor
@Builder
@Table(name = "orderItem")
@AllArgsConstructor
public class OrderItemEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "orderItemId",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderItemId;

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false)
    private OrderEntity order;


    @Column(name = "productId",nullable = false)
    private Integer productId;

    @Column(name = "productName",nullable = false)
    private String productName;

    @Column(name = "quantity",nullable = false)
    private Integer quantity;

    @Column(name = "price",nullable = false)
    private Double price;

    @Column(name = "subtotal",nullable = false)
    private Double subtotal;
}
