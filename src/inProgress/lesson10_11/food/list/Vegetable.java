package inProgress.lesson10_11.food.list;

import inProgress.lesson10_11.food.list.Food;
import inProgress.lesson10_11.food.list.FoodType;

public class Vegetable extends Food {
    public Vegetable(String name) {
        super(name);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.VEGETABLE;
    }
}
