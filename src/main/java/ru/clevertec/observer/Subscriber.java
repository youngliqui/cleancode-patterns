package ru.clevertec.observer;

public interface Subscriber {
    void update(String message);

    String getName();
}
