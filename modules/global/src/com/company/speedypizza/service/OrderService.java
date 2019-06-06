package com.company.speedypizza.service;

import com.company.speedypizza.entity.Order;

import java.math.BigDecimal;

public interface OrderService {
    String NAME = "speedypizza_OrderService";

    BigDecimal calculateAmount(Order order);
}