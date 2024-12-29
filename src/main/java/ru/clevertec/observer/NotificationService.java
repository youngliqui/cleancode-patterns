package ru.clevertec.observer;

public interface NotificationService {
    void addSubscriber(Subscriber subscriber);

    void notifySubscriber(String subscriberName, String message);
}
