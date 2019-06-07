package com.company.speedypizza.web.screens.order;

import com.company.speedypizza.entity.Dish;
import com.company.speedypizza.service.OrderService;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.model.CollectionChangeType;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionPropertyContainer;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza.entity.Order;
import com.haulmont.reports.gui.actions.EditorPrintFormAction;

import javax.inject.Inject;
import java.math.BigDecimal;

@UiController("speedypizza_Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
@LoadDataBeforeShow
public class OrderEdit extends StandardEditor<Order> {

    @Inject
    private OrderService orderService;
    @Inject
    private CollectionPropertyContainer<Dish> dishesDc;
    @Inject
    private Button printInvoice;

    @Subscribe
    private void onInit(InitEvent event) {
        printInvoice.setAction(new EditorPrintFormAction(this, null));
    }

    @Subscribe(id = "dishesDc", target = Target.DATA_CONTAINER)
    private void onDishesDcCollectionChange(CollectionContainer.CollectionChangeEvent<Dish> event) {
        if(event.getChangeType()!= CollectionChangeType.REFRESH){
            orderService.calculateOrderDiscount(getEditedEntity());
            orderService.calculateCustomerDiscount(getEditedEntity().getCustomer());
            BigDecimal amount = orderService.calculateAmount(getEditedEntity());
            getEditedEntity().setTotal(amount);
        }
    }
    
    
    
}