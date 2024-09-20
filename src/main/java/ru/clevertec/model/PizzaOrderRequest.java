package ru.clevertec.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class PizzaOrderRequest {
    private String type;
    private String clientName;

    private boolean withCheeseBoard;
    private boolean withDoubleCheese;
}
