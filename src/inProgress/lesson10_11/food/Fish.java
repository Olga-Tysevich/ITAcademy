package inProgress.lesson10_11.food;

public class Fish extends Food{
    public Fish(String name) {
        super(name);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.FISH;
    }
}
