package checked.lesson10_11.food.model;

import checked.lesson10_11.food.Food;
import checked.lesson10_11.food.FoodType;

public class Salmon extends Food {
    public Salmon(String name) {
        super(name);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.FISH;
    }
}
