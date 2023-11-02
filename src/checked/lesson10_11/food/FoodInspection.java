package checked.lesson10_11.food;

public abstract class FoodInspection {

    public static boolean isVegetarian(Food[] foods) {
        boolean isVegetarian = true;
        for (Food f : foods) {
            if (!f.getFoodType().isVegetarian()) {
                isVegetarian = false;
                break;
            }
        }
        return isVegetarian;
    }
}
