package ru.clevertec.proxy;

import lombok.AllArgsConstructor;
import ru.clevertec.model.Pizza;
import ru.clevertec.model.PizzaOrderRequest;
import ru.clevertec.service.PizzaPreparationService;
import ru.clevertec.service.PizzaPreparationServiceImpl;

import java.lang.reflect.Method;

@AllArgsConstructor
public class PizzaPreparationServiceProxy implements PizzaPreparationService {
    private PizzaPreparationServiceImpl realService;

    @Override
    public Pizza preparePizza(PizzaOrderRequest pizzaOrder) {
        String methodName = "preparePizza";
        String className = realService.getClass().getName();
        Pizza pizza;

        if (isMethodAnnotatedWithLog(realService.getClass(), methodName)) {
            actionBefore(className, methodName);

            pizza = realService.preparePizza(pizzaOrder);

            actionAfter(className, methodName);
        } else {
            pizza = realService.preparePizza(pizzaOrder);
        }

        return pizza;
    }

    private void actionBefore(String className, String methodName) {
        System.out.println("+++ Class: " + className + ", Method: " + methodName + " is started");
    }

    private void actionAfter(String className, String methodName) {
        System.out.println("--- Class: " + className + ", Method: " + methodName + " is executed");
    }

    private boolean isMethodAnnotatedWithLog(Class<?> realServiceClass, String methodName) {
        try {
            Method method = realServiceClass.getMethod(methodName, PizzaOrderRequest.class);

            return method.isAnnotationPresent(Log.class);
        } catch (NoSuchMethodException e) {
            return false;
        }
    }
}
