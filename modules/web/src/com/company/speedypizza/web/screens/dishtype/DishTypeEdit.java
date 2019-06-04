package com.company.speedypizza.web.screens.dishtype;

import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza.entity.DishType;

@UiController("speedypizza_DishType.edit")
@UiDescriptor("dish-type-edit.xml")
@EditedEntityContainer("dishTypeDc")
@LoadDataBeforeShow
public class DishTypeEdit extends StandardEditor<DishType> {
}