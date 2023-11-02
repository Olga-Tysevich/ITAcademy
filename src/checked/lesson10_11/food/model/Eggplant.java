package checked.lesson10_11.food.model;

import checked.lesson10_11.food.Food;
import checked.lesson10_11.food.FoodType;

public class Eggplant extends Food {

    public Eggplant(String name) {
        super(name);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.VEGETABLE;
    }
}
