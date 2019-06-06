package com.company.speedypizza.service;

import com.company.speedypizza.entity.Dish;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.TypedQuery;
import com.haulmont.cuba.core.global.View;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service(DishService.NAME)
public class DishServiceBean implements DishService {

    @Inject
    private Persistence persistence;

    @Override
    public List<Dish> getUsedDishes() {
        return persistence.callInTransaction(em ->{
            TypedQuery<Dish> query = em.createQuery(
                    "select distinct d from speedypizza_Order o" +
                            "join o.dishes d" +
                            "where  @between(c.createTs, now-7, now+1, day)",
                    Dish.class);
            query.setViewName(View.LOCAL);

            return query.getResultList();
        });
    }


}