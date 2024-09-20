package ru.clevertec.strategy;

import java.util.List;

public interface PizzaStrategy {
    List<String> getIngredients();

    String getPizzaType();
}
