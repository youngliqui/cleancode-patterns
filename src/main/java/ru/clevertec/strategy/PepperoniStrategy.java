package ru.clevertec.strategy;

import java.util.List;

public class PepperoniStrategy implements PizzaStrategy {

    @Override
    public List<String> getIngredients() {
        return List.of(
                "Mozzarella", "Pepperoni", "Oregano", "Cherry Tomatoes", "Basil Leaves"
        );
    }

    @Override
    public String getPizzaType() {
        return "Pepperoni";
    }
}
