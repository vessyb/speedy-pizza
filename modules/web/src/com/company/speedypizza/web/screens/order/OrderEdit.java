package com.company.speedypizza.web.screens.order;

import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza.entity.Order;

@UiController("speedypizza_Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
@LoadDataBeforeShow
public class OrderEdit extends StandardEditor<Order> {
}