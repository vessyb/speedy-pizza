package com.company.speedypizza.web.screens.dish;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza.entity.Dish;
import com.haulmont.cuba.gui.screen.LookupComponent;

import javax.inject.Inject;

@UiController("speedypizza_Dish.browse")
@UiDescriptor("dish-browse.xml")
@LookupComponent("dishesTable")
@LoadDataBeforeShow
public class DishBrowse extends StandardLookup<Dish> {


    @Inject
    private UiComponents uiComponents;
    @Inject
    private GroupTable<Dish> dishesTable;

    @Subscribe
    private void onInit(InitEvent event) {
        dishesTable.addGeneratedColumn("name", entity -> {
            Image image = uiComponents.create(Image.NAME);
            image.setScaleMode(Image.ScaleMode.CONTAIN);
            image.setHeight("40");
            image.setWidth("40");

            FileDescriptor imageFile = entity.getPhoto();
            image.setSource(FileDescriptorResource.class)
                    .setFileDescriptor(imageFile);

            Label label = uiComponents.create(Label.NAME);
            label.setValue(entity.getName());
            label.setAlignment(Component.Alignment.MIDDLE_LEFT);

            HBoxLayout hBoxLayout = uiComponents.create(HBoxLayout.NAME);
            hBoxLayout.setSpacing(true);
            hBoxLayout.add(image);
            hBoxLayout.add(label);

            return hBoxLayout;
        });
    }

}