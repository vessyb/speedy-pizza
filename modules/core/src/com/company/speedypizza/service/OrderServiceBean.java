package com.company.speedypizza.service;

import com.company.speedypizza.entity.Dish;
import com.company.speedypizza.entity.Order;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service(OrderService.NAME)
public class OrderServiceBean implements OrderService {

    @Override
    public BigDecimal calculateAmount(Order order) {
        BigDecimal amount = BigDecimal.valueOf(0);

        if(order.getDishes() != null) {
            for (Dish dish : order.getDishes()) {
                amount = amount.add(dish.getPrice());
            }
        }
        return amount;
    }
}