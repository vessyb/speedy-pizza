package com.company.speedypizza.listener;

import com.company.speedypizza.entity.Order;
import com.google.common.eventbus.Subscribe;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.app.UniqueNumbersService;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component(OrderEntityListener.NAME)
public class OrderEntityListener implements BeforeInsertEntityListener<Order> {
    public static final String NAME = "speedypizza_OrderEntityListener";

    @Inject
    private UniqueNumbersService uniqueNumbersService;

    @Override
    public void onBeforeInsert(Order entity, EntityManager entityManager) {
        long orderNumber = uniqueNumbersService.getNextNumber(entity.getCustomer().getUsername().getLogin());
        entity.setNumber(String.format("%d-%tD", orderNumber, entity.getDate()));
    }

}