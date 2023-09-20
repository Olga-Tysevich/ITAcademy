package forCheck.lesson10_11.food;

import forCheck.lesson10_11.food.list.Food;

public class FoodInspection {

    public boolean isVegetarian(Food[] foods) {
        boolean isVegetarian = false;
        for (Food f : foods) {
            isVegetarian = switch (f.getFoodType()) {
                case FISH, MEAT, MILK, UNKNOWN -> false;
                case FRUIT, VEGETABLE -> true;
            };
            if (!isVegetarian) {
                break;
            }
        }

        return isVegetarian;
    }
}
