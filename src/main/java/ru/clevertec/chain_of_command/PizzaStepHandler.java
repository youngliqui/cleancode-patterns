package ru.clevertec.chain_of_command;

import ru.clevertec.model.Pizza;

public abstract class PizzaStepHandler implements PizzaHandler {
    protected PizzaHandler nextHandler;

    @Override
    public void setNext(PizzaHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public abstract void handle(Pizza pizza) throws InterruptedException;

    protected void handleNext(Pizza pizza) throws InterruptedException {
        if (nextHandler != null) {
            nextHandler.handle(pizza);
        }
    }
}
