package ru.clevertec.chain_of_command;

import ru.clevertec.model.Pizza;

import java.util.concurrent.TimeUnit;

public class PizzaSlicingHandler extends PizzaStepHandler {
    @Override
    public void handle(Pizza pizza) throws InterruptedException {
        System.out.println("Slicing " + pizza.getType());
        TimeUnit.SECONDS.sleep(2);
        pizza.setSliced(true);

        handleNext(pizza);
    }
}