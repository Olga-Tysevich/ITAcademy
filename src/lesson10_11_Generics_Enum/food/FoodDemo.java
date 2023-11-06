package lesson10_11_Generics_Enum.food;

import lesson10_11_Generics_Enum.food.model.Beef;
import lesson10_11_Generics_Enum.food.model.Eggplant;
import lesson10_11_Generics_Enum.food.model.Mango;
import lesson10_11_Generics_Enum.food.model.Salmon;

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

        System.out.println(FoodInspection.isVegetarian(new Food[]{beef, salmon, mango, eggplant}));
        System.out.println(FoodInspection.isVegetarian(new Food[]{mango, eggplant, beef, salmon}));
        System.out.println(FoodInspection.isVegetarian(new Food[]{mango, eggplant, beef}));
        System.out.println(FoodInspection.isVegetarian(new Food[]{mango, eggplant}));
        System.out.println(FoodInspection.isVegetarian(new Food[]{mango, mango, eggplant}));

    }
    }
