package lesson10_11_Generics_Enum.food.model;

import lesson10_11_Generics_Enum.food.Food;
import lesson10_11_Generics_Enum.food.FoodType;

public class Eggplant extends Food {

    public Eggplant(String name) {
        super(name);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.VEGETABLE;
    }
}
