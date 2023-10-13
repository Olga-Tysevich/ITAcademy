package forCheck.lesson10_11.food.model;

import forCheck.lesson10_11.food.Food;
import forCheck.lesson10_11.food.FoodType;

public class Mango extends Food {
    public Mango(String name) {
        super(name);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.FRUIT;
    }
}
