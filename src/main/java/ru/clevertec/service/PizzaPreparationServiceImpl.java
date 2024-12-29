package ru.clevertec.service;

import lombok.NoArgsConstructor;
import ru.clevertec.chain_of_command.*;
import ru.clevertec.exception.PreparationException;
import ru.clevertec.model.Pizza;
import ru.clevertec.model.PizzaOrderRequest;
import ru.clevertec.proxy.Log;
import ru.clevertec.strategy.PizzaStrategy;

import java.util.List;

@NoArgsConstructor
public class PizzaPreparationServiceImpl implements PizzaPreparationService {
    private List<PizzaStrategy> pizzaStrategies;

    public PizzaPreparationServiceImpl(List<PizzaStrategy> pizzaStrategies) {
        this.pizzaStrategies = pizzaStrategies;
    }

    @Log
    public Pizza preparePizza(PizzaOrderRequest pizzaOrder) {
        String pizzaType = pizzaOrder.getType();
        PizzaStrategy pizzaStrategy = findStrategy(pizzaType);

        Pizza pizza = new Pizza(pizzaType);
        PizzaHandler chain = createChain(pizzaStrategy.getIngredients());

        try {
            chain.handle(pizza);
        } catch (InterruptedException e) {
            throw new PreparationException("Error with the pizza cooking chain: " + e.getMessage());
        }

        return pizza;
    }

    private PizzaHandler createChain(List<String> ingredients) {
        PizzaHandler prepareDough = new DoughPreparationHandler();
        PizzaHandler addTomatoSauce = new AddingSauceHandler();
        PizzaHandler addMainIngredients = new IngredientHandler(ingredients);
        PizzaHandler addCheese = new SprinklingOfCheeseHandler();
        PizzaHandler bakePizza = new OvenBakingHandler();
        PizzaHandler cutPizza = new PizzaSlicingHandler();

        prepareDough.setNext(addTomatoSauce);
        addTomatoSauce.setNext(addMainIngredients);
        addMainIngredients.setNext(addCheese);
        addCheese.setNext(bakePizza);
        bakePizza.setNext(cutPizza);

        return prepareDough;
    }

    private PizzaStrategy findStrategy(String pizzaType) {
        return pizzaStrategies.stream()
                .filter(strategy ->
                        strategy.getPizzaType().equalsIgnoreCase(pizzaType))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Unknown pizza type: " + pizzaType));
    }
}
