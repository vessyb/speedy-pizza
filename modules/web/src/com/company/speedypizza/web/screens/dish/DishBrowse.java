package com.company.speedypizza.web.screens.dish;

import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza.entity.Dish;

@UiController("speedypizza_Dish.browse")
@UiDescriptor("dish-browse.xml")
@LookupComponent("dishesTable")
@LoadDataBeforeShow
public class DishBrowse extends StandardLookup<Dish> {
}