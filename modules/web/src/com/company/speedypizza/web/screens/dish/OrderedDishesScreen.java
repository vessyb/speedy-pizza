package com.company.speedypizza.web.screens.dish;

import com.company.speedypizza.entity.Dish;
import com.company.speedypizza.service.DishService;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.core.global.View;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;
import java.util.List;

@UiController("speedypizza_OrderedDishesScreen")
@UiDescriptor("ordered-dishes-screen.xml")
public class OrderedDishesScreen extends Screen {

    @Inject
    private DishService dishService;
    @Inject
    private CollectionContainer<Dish> dishesDc;
    @Inject
    private DataManager dataManager;

    @Subscribe
    private void onBeforeShowdishesDc(BeforeShowEvent event) {
        LoadContext<Dish> loadContext = new LoadContext<>(Dish.class);
        loadContext.setQuery(new LoadContext.Query("select distinct c from speedypizza_Order v join v.dishes c where @between(c.createTs, now-7, now+1, day)")).setView(View.LOCAL);

        List<Dish> dishes = dataManager.loadList(loadContext);
        dishesDc.setItems(dishes);
    }
}