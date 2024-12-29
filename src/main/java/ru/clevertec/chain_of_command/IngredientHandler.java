package ru.clevertec.chain_of_command;

import ru.clevertec.model.Pizza;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class IngredientHandler extends PizzaStepHandler {
    private final List<String> ingredientsToAdd;

    public IngredientHandler(List<String> ingredientsToAdd) {
        this.ingredientsToAdd = ingredientsToAdd;
    }

    @Override
    public void handle(Pizza pizza) throws InterruptedException {
        for (String ingredient : ingredientsToAdd) {
            System.out.println("Adding " + ingredient + " to " + pizza.getType());
            TimeUnit.SECONDS.sleep(2);
            pizza.addIngredient(ingredient);
        }

        handleNext(pizza);
    }
}
