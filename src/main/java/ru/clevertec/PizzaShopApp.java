package ru.clevertec;

import ru.clevertec.facade.PizzeriaService;
import ru.clevertec.observer.Client;
import ru.clevertec.observer.OrderNotificationService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PizzaShopApp {
    public static void main(String[] args) {
        OrderNotificationService notifier = new OrderNotificationService();
        PizzeriaService facade = new PizzeriaService(notifier);

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.submit(() -> {
            Client client = new Client("Client 1");
            notifier.addSubscriber(client);
            facade.orderPizza("Margarita", client.getName(), true, false);
        });

        executorService.submit(() -> {
            Client client = new Client("Client 2");
            notifier.addSubscriber(client);
            facade.orderPizza("Pepperoni", client.getName(), false, false);
        });

        executorService.submit(() -> {
            Client client = new Client("Client 3");
            notifier.addSubscriber(client);
            facade.orderPizza("Hawaiian", client.getName(), false, true);
        });

        executorService.shutdown();
        executorService.close();
    }
}
