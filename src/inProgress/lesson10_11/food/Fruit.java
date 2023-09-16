package inProgress.lesson10_11.food;

public class Fruit extends Food{
    public Fruit(String name) {
        super(name);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.FRUIT;
    }
}
