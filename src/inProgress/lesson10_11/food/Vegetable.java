package inProgress.lesson10_11.food;

public class Vegetable extends Food{
    public Vegetable(String name) {
        super(name);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.VEGETABLE;
    }
}
