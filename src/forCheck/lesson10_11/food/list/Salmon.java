package forCheck.lesson10_11.food.list;

public class Salmon extends Food {
    private final FoodType type = FoodType.FISH;
    public Salmon(String name) {
        super(name);
    }

    @Override
    public FoodType getFoodType() {
        return type;
    }
}
