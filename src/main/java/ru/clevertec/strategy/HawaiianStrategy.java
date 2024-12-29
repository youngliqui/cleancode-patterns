package ru.clevertec.strategy;

import java.util.List;

public class HawaiianStrategy implements PizzaStrategy {

    @Override
    public List<String> getIngredients() {
        return List.of(
                "Alfredo sauce", "Chicken", "Mozzarella", "Pineapple"
        );
    }

    @Override
    public String getPizzaType() {
        return "Hawaiian";
    }
}
