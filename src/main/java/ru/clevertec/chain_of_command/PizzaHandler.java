package ru.clevertec.chain_of_command;

import ru.clevertec.model.Pizza;

public interface PizzaHandler {
    void setNext(PizzaHandler pizzaHandler);

    void handle(Pizza pizza) throws InterruptedException;
}
