package com.company.speedypizza.web.screens.dish;

import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza.entity.Dish;

@UiController("speedypizza_Dish.edit")
@UiDescriptor("dish-edit.xml")
@EditedEntityContainer("dishDc")
@LoadDataBeforeShow
public class DishEdit extends StandardEditor<Dish> {
}