package com.company.speedypizza.web.screens.dishtype;

import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza.entity.DishType;

@UiController("speedypizza_DishType.browse")
@UiDescriptor("dish-type-browse.xml")
@LookupComponent("dishTypesTable")
@LoadDataBeforeShow
public class DishTypeBrowse extends StandardLookup<DishType> {
}