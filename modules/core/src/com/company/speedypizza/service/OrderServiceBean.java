package com.company.speedypizza.service;

import com.company.speedypizza.entity.Customer;
import com.company.speedypizza.entity.Dish;
import com.company.speedypizza.entity.Order;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service(OrderService.NAME)
public class OrderServiceBean implements OrderService {

    @Override
    public BigDecimal calculateCustomerDiscount(Customer customer) {
        BigDecimal discount = BigDecimal.valueOf(0);

        int ordersAmount = customer.getOrders().size();
        if(ordersAmount > 50){
            discount = discount.add(BigDecimal.valueOf(15));
            if(ordersAmount > 100){
                discount = discount.add(BigDecimal.valueOf(5));
            }
            customer.setDiscount(discount);
        }
        return discount;
    }

    @Override
    public BigDecimal calculateOrderDiscount(Order order) {
        BigDecimal discount = BigDecimal.valueOf(0);

        int dishesAmount = order.getDishes().size();
        if(dishesAmount > 3){
            discount = discount.add(BigDecimal.valueOf(5));
            if(dishesAmount > 10){
                discount = discount.add(BigDecimal.valueOf(5));
            }
            order.setDiscount(discount);
        }
        return discount;
    }

    @Override
    public BigDecimal calculateAmount(Order order) {

        BigDecimal amount = BigDecimal.valueOf(0);

        if(order.getDishes() != null) {
            for (Dish dish : order.getDishes()) {
                amount = amount.add(dish.getPrice());
            }
        }

        if(!order.getCustomer().getDiscount().equals(BigDecimal.valueOf(0))){
            BigDecimal discount = (order.getCustomer().getDiscount().add(order.getDiscount()))
                    .divide(BigDecimal.valueOf(100));
            amount = amount.subtract(amount.multiply(discount));
        }
        return amount;
    }




}