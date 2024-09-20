package ru.clevertec.strategy;

import java.util.List;

public class MargaritaStrategy implements PizzaStrategy {
    @Override
    public List<String> getIngredients() {
        return List.of(
                "Italian herbs", "Tomatoes", "Mozzarella"
        );
    }

    @Override
    public String getPizzaType() {
        return "Margarita";
    }
}
