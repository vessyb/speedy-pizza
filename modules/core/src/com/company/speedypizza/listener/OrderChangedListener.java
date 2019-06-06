package com.company.speedypizza.listener;

import com.company.speedypizza.entity.Order;
import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("speedypizza_OrderChangedListener")
public class OrderChangedListener {

    @EventListener
    private void beforeCommit(EntityChangedEvent<Order, UUID> event) {

    }
}