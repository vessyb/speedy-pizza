package com.company.speedypizza.service;

import com.company.speedypizza.entity.Dish;

import java.util.List;

public interface DishService {
    String NAME = "speedypizza_DishService";

    List<Dish> getUsedDishes();
}