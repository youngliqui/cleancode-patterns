package ru.clevertec.service;

import ru.clevertec.model.Pizza;
import ru.clevertec.model.PizzaOrderRequest;

public interface PizzaPreparationService {
    Pizza preparePizza(PizzaOrderRequest pizzaOrder);
}
