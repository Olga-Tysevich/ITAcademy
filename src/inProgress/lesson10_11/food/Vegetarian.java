package inProgress.lesson10_11.food;

import inProgress.lesson10_11.food.list.Food;

public class Vegetarian {

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
