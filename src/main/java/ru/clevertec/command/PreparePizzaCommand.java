package ru.clevertec.command;

import lombok.AllArgsConstructor;
import ru.clevertec.service.PizzaPreparationService;
import ru.clevertec.model.Pizza;
import ru.clevertec.model.PizzaOrderRequest;

@AllArgsConstructor
public class PreparePizzaCommand implements Command {
    private PizzaPreparationService preparationService;
    private PizzaOrderRequest pizzaOrder;

    @Override
    public void execute() {
        Pizza preparedPizza = preparationService.preparePizza(pizzaOrder);
        System.out.println(preparedPizza);
    }
}
