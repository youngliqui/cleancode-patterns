package ru.clevertec.chain_of_command;

import ru.clevertec.model.Pizza;

import java.util.concurrent.TimeUnit;

public class SprinklingOfCheeseHandler extends PizzaStepHandler {
    @Override
    public void handle(Pizza pizza) throws InterruptedException {
        System.out.println("Sprinkling cheese to " + pizza.getType());
        TimeUnit.SECONDS.sleep(2);

        handleNext(pizza);
    }
}
