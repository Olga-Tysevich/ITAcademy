package inProgress.lesson10_11.food.list;

public class Meat extends Food {
    private final FoodType type = FoodType.MEAT;

    public Meat(String name) {
        super(name);
    }

    @Override
    public FoodType getFoodType() {
        return type;
    }

}
