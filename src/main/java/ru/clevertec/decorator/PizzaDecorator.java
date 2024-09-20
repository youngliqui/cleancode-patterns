package ru.clevertec.decorator;

import ru.clevertec.PizzaPreparationService;
import ru.clevertec.model.Pizza;
import ru.clevertec.model.PizzaOrderRequest;

public abstract class PizzaDecorator implements PizzaPreparationService {
    private final PizzaPreparationService decoratedPreparationService;

    public PizzaDecorator(PizzaPreparationService decoratedPizza) {
        this.decoratedPreparationService = decoratedPizza;
    }

    @Override
    public Pizza preparePizza(PizzaOrderRequest order) {
        Pizza pizza = decoratedPreparationService.preparePizza(order);
        addAdditionalIngredient(pizza);

        return pizza;
    }

    protected abstract void addAdditionalIngredient(Pizza pizza);
}
