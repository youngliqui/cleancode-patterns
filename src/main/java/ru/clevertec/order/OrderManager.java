package ru.clevertec.order;

public interface OrderManager {
    void takeOrder(String type, String clientName, boolean withCheeseBoard, boolean withDoubleCheese);
}
