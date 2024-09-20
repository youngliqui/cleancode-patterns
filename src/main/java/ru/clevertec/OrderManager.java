package ru.clevertec;

public interface OrderManager {
    void takeOrder(String type, String clientName, boolean withCheeseBoard, boolean withDoubleCheese);
}
