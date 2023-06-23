package com.epam.collections.queue;

import java.util.*;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        List<Integer> dishOrder = new ArrayList<>();
        Queue<Integer> dishes = new LinkedList<>();

        for (int i = 1; i <= numberOfDishes; i++) {
            dishes.add(i);
        }

        int count = 1;
        while (!dishes.isEmpty()) {
            if (count % everyDishNumberToEat == 0) {
                int dish = dishes.poll();
                dishOrder.add(dish);
            } else {
                int dish = dishes.poll();
                dishes.add(dish);
            }
            count++;
        }

        return dishOrder;
    }
}
