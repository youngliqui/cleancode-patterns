package ru.clevertec.observer;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Client implements Subscriber {
    private String name;

    @Override
    public void update(String message) {
        System.out.println(name + " received notification: " + message);
    }

    @Override
    public String getName() {
        return name;
    }
}
