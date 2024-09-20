package ru.clevertec.chain_of_command;

import ru.clevertec.model.Pizza;

import java.util.concurrent.TimeUnit;

public class DoughPreparationHandler extends PizzaStepHandler {
    @Override
    public void handle(Pizza pizza) throws InterruptedException {
        System.out.println("Preparing dough for " + pizza.getType());
        TimeUnit.SECONDS.sleep(2);
        pizza.addIngredient("Dough");

        handleNext(pizza);
    }
}
