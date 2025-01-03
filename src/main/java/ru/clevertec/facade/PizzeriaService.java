package ru.clevertec.facade;

import ru.clevertec.order.OrderManager;
import ru.clevertec.order.PizzaOrderManager;
import ru.clevertec.observer.OrderNotificationService;

public class PizzeriaService {
    private final OrderManager orderManager;

    public PizzeriaService(OrderNotificationService orderNotifier) {
        orderManager = new PizzaOrderManager(orderNotifier);
    }

    public void orderPizza(String type, String clientName, boolean withCheeseBoard, boolean withDoubleCheese) {
        orderManager.takeOrder(type, clientName, withCheeseBoard, withDoubleCheese);
    }
}
