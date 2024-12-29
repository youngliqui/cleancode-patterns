package ru.clevertec.chain_of_command;

import ru.clevertec.model.Pizza;

import java.util.concurrent.TimeUnit;

public class OvenBakingHandler extends PizzaStepHandler {
    @Override
    public void handle(Pizza pizza) throws InterruptedException {
        System.out.println("Baking " + pizza.getType());
        TimeUnit.SECONDS.sleep(4);
        pizza.setBacked(true);

        handleNext(pizza);
    }
}
