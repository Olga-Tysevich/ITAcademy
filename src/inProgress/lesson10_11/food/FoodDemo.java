package inProgress.lesson10_11.food;

public class FoodDemo {
    public static void main(String[] args) {
        Meat meat1 = new Meat("Beef");
        System.out.println("Name: " + meat1.getName() + ", type: " + meat1.getFoodType());
        Meat meat2 = new Meat("Pork");
        System.out.println("Name: " + meat2.getName() + ", type: " + meat2.getFoodType());

        Fish fish1 = new Fish("Pink salmon");
        System.out.println("Name: " + fish1.getName() + ", type: " + fish1.getFoodType());
        Fish fish2 = new Fish("Herring");
        System.out.println("Name: " + fish2.getName() + ", type: " + fish2.getFoodType());

        Fruit fruit1 = new Fruit("Avocado");
        System.out.println("Name: " + fruit1.getName() + ", type: " + fruit1.getFoodType());
        Fruit fruit2 = new Fruit("Mango");
        System.out.println("Name: " + fruit2.getName() + ", type: " + fruit2.getFoodType());

        Vegetable vegetable1 = new Vegetable("Eggplant");
        System.out.println("Name: " + vegetable1.getName() + ", type: " + vegetable1.getFoodType());
        Vegetable vegetable2 = new Vegetable("Zucchini");
        System.out.println("Name: " + vegetable2.getName() + ", type: " + vegetable2.getFoodType());

        Food[] foodList1 = {meat1, meat2, fish1, fish2, fruit1, fruit2, vegetable1, vegetable2};
        Food[] foodList2 = {fruit1, fruit2, vegetable1, vegetable2, meat1, meat2, fish1, fish2};
        Food[] foodList3 = {fruit1, fruit2, vegetable1, meat1, vegetable2};
        Food[] foodList4 = {fruit1, fruit2, vegetable1, vegetable2};

        Vegetarian checkVegetarian = new Vegetarian();

        System.out.println(checkVegetarian.isVegetarian(foodList1));
        System.out.println(checkVegetarian.isVegetarian(foodList2));
        System.out.println(checkVegetarian.isVegetarian(foodList3));
        System.out.println(checkVegetarian.isVegetarian(foodList4));

    }
}
