package ru.clevertec.observer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OrderNotificationService implements NotificationService {
    private final Map<String, Subscriber> subscribers;

    public OrderNotificationService() {
        subscribers = new HashMap<>();
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.put(subscriber.getName(), subscriber);
    }

    @Override
    public void notifySubscriber(String subscriberName, String message) {
        Optional.ofNullable(subscribers.get(subscriberName))
                .ifPresent(subscriber ->
                        subscriber.update(message));
    }
}
