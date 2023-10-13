package forCheck.lesson10_11.food.model;

import forCheck.lesson10_11.food.Food;
import forCheck.lesson10_11.food.FoodType;

public class Beef extends Food {

    public Beef(String name) {
        super(name);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.MEAT;
    }

}
