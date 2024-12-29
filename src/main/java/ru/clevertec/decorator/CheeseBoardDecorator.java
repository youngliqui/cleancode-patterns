package ru.clevertec.decorator;

import ru.clevertec.service.PizzaPreparationService;
import ru.clevertec.model.Pizza;

public class CheeseBoardDecorator extends PizzaDecorator {
    public CheeseBoardDecorator(PizzaPreparationService preparationService) {
        super(preparationService);
    }

    @Override
    protected void addAdditionalIngredient(Pizza pizza) {
        System.out.println("Adding cheese board.");
        pizza.addAdditionalIngredient("Cheese board");
    }
}
