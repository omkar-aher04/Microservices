package com.order_service.calculator;

import com.order_service.entity.OrderEntity;
import com.order_service.entity.OrderItemEntity;
import org.springframework.stereotype.Component;

@Component
public class PriceCalculator {

    public void calculateOrder(OrderEntity order) {

        double totalAmount = 0;

        for (OrderItemEntity item : order.getItems()) {

            double subtotal = calculateSubtotal(item);

            item.setSubtotal(subtotal);

            item.setOrder(order);

            totalAmount += subtotal;
        }

        order.setTotalAmount(totalAmount);
    }

    private double calculateSubtotal(OrderItemEntity item) {

        return item.getPrice() * item.getQuantity();
    }
}