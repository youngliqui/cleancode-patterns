package ru.clevertec.order;

import ru.clevertec.command.Command;
import ru.clevertec.command.PreparePizzaCommand;
import ru.clevertec.config.PizzeriaConfig;
import ru.clevertec.decorator.CheeseBoardDecorator;
import ru.clevertec.decorator.DoubleCheeseDecorator;
import ru.clevertec.model.PizzaOrderRequest;
import ru.clevertec.observer.NotificationService;
import ru.clevertec.observer.OrderNotificationService;
import ru.clevertec.proxy.PizzaPreparationServiceProxy;
import ru.clevertec.service.PizzaPreparationService;
import ru.clevertec.service.PizzaPreparationServiceImpl;
import ru.clevertec.strategy.HawaiianStrategy;
import ru.clevertec.strategy.MargaritaStrategy;
import ru.clevertec.strategy.PepperoniStrategy;

import java.util.List;
import java.util.concurrent.Semaphore;

public class PizzaOrderManager implements OrderManager {
    private final NotificationService notificationService;
    private final Semaphore semaphore;

    public PizzaOrderManager(OrderNotificationService notifier) {
        this.notificationService = notifier;
        this.semaphore = new Semaphore(PizzeriaConfig.MAX_WORKERS);
    }

    @Override
    public void takeOrder(String type, String clientName, boolean withCheeseBoard, boolean withDoubleCheese) {
        new Thread(() -> {
            try {
                semaphore.acquire();

                PizzaOrderRequest order = new PizzaOrderRequest(type, clientName, withCheeseBoard, withDoubleCheese);
                System.out.println("Order taken: " + order.getType() + ", cheese board: " + withCheeseBoard
                        + ", double cheese: " + withDoubleCheese);

                Command prepareCommand = getPrepareCommand(withCheeseBoard, withDoubleCheese, order);
                fulfillOrder(order, prepareCommand);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                semaphore.release();
            }
        }).start();
    }

    private void fulfillOrder(PizzaOrderRequest order, Command prepareCommand) {
        prepareCommand.execute();

        System.out.println("Order completed: " + order);
        notificationService.notifySubscriber(order.getClientName(), order.getType() + " is ready!");
    }

    private Command getPrepareCommand(boolean withCheeseBoard, boolean withDoubleCheese, PizzaOrderRequest order) {
        PizzaPreparationService preparationService = new PizzaPreparationServiceProxy(
                new PizzaPreparationServiceImpl(List.of(
                        new HawaiianStrategy(),
                        new MargaritaStrategy(),
                        new PepperoniStrategy()
                ))
        );

        if (withCheeseBoard) {
            preparationService = new CheeseBoardDecorator(preparationService);
        }

        if (withDoubleCheese) {
            preparationService = new DoubleCheeseDecorator(preparationService);
        }

        return new PreparePizzaCommand(preparationService, order);
    }
}
