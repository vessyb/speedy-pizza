package com.company.speedypizza.web.screens.customer;

import com.company.speedypizza.entity.Customer;
import com.company.speedypizza.entity.Dish;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.reports.gui.actions.RunReportAction;

import javax.inject.Inject;

@UiController("speedypizza_Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("customersTable")
@LoadDataBeforeShow
public class CustomerBrowse extends StandardLookup<Customer> {

    @Inject
    private Button showDiscount;

    @Subscribe
    private void onInit(InitEvent event) {
        showDiscount.setAction(new RunReportAction());
    }
}