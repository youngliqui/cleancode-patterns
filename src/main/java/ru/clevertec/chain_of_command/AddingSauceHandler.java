package ru.clevertec.chain_of_command;

import ru.clevertec.model.Pizza;

import java.util.concurrent.TimeUnit;

public class AddingSauceHandler extends PizzaStepHandler {
    @Override
    public void handle(Pizza pizza) throws InterruptedException {
        System.out.println("Adding tomato sauce to " + pizza.getType());
        TimeUnit.SECONDS.sleep(2);
        pizza.addIngredient("Tomato Sauce");

        handleNext(pizza);
    }
}
