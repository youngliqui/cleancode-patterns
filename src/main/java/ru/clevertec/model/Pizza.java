package ru.clevertec.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Pizza {
    @Getter
    private final String type;
    private final List<String> ingredients;
    private final List<String> additionalIngredients;
    @Setter
    private boolean isBacked;
    @Setter
    private boolean isSliced;

    public Pizza(String type) {
        this.type = type;
        this.ingredients = new ArrayList<>();
        this.additionalIngredients = new ArrayList<>();
    }

    public void addIngredient(String ingredient) {
        ingredients.add(ingredient);
    }

    public void addAdditionalIngredient(String additionalIngredient) {
        additionalIngredients.add(additionalIngredient);
    }
}
