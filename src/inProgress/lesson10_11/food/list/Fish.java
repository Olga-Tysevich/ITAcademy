package inProgress.lesson10_11.food.list;

public class Fish extends Food {
    public Fish(String name) {
        super(name);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.FISH;
    }
}
