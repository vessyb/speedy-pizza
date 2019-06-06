package com.company.speedypizza.web.screens.dishtype;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza.entity.DishType;
import com.haulmont.reports.gui.actions.TablePrintFormAction;

import javax.inject.Inject;

@UiController("speedypizza_DishType.browse")
@UiDescriptor("dish-type-browse.xml")
@LookupComponent("dishTypesTable")
@LoadDataBeforeShow
public class DishTypeBrowse extends StandardLookup<DishType> {

    @Inject
    private Button printTypes;
    @Inject
    private GroupTable<DishType> dishTypesTable;

    @Subscribe
    private void onInit(InitEvent event) {
        printTypes.setAction(new TablePrintFormAction(dishTypesTable));
    }
}