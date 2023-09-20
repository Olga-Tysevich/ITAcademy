package forCheck.lesson10_11.food;

import forCheck.lesson10_11.food.list.*;

public class FoodDemo {
    public static void main(String[] args) {
        Beef beef = new Beef("Beef");
        System.out.println("Name: " + beef.getName() + ", type: " + beef.getFoodType());

        Salmon salmon = new Salmon("Salmon");
        System.out.println("Name: " + salmon.getName() + ", type: " + salmon.getFoodType());

        Mango mango = new Mango("Mango");
        System.out.println("Name: " + mango.getName() + ", type: " + mango.getFoodType());

        Eggplant eggplant = new Eggplant("Eggplant");
        System.out.println("Name: " + eggplant.getName() + ", type: " + eggplant.getFoodType());

        Food[] foodList1 = {beef, salmon, mango, eggplant};
        Food[] foodList2 = {mango, eggplant, beef, salmon};
        Food[] foodList3 = {mango, eggplant, beef};
        Food[] foodList4 = {mango, eggplant};

        FoodInspection checkFoodInspection = new FoodInspection();

        System.out.println(checkFoodInspection.isVegetarian(foodList1));
        System.out.println(checkFoodInspection.isVegetarian(foodList2));
        System.out.println(checkFoodInspection.isVegetarian(foodList3));
        System.out.println(checkFoodInspection.isVegetarian(foodList4));

    }
}
