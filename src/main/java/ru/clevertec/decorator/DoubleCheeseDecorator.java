package ru.clevertec.decorator;

import ru.clevertec.service.PizzaPreparationService;
import ru.clevertec.model.Pizza;

public class DoubleCheeseDecorator extends PizzaDecorator {


    public DoubleCheeseDecorator(PizzaPreparationService preparationService) {
        super(preparationService);
    }

    @Override
    protected void addAdditionalIngredient(Pizza pizza) {
        System.out.println("Adding double cheese");
        pizza.addAdditionalIngredient("Double cheese");
    }
}
