package inProgress.lesson10_11.food.list;

import inProgress.lesson10_11.food.list.Food;
import inProgress.lesson10_11.food.list.FoodType;

public class Fruit extends Food {
    public Fruit(String name) {
        super(name);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.FRUIT;
    }
}