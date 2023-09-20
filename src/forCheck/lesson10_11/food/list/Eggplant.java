package forCheck.lesson10_11.food.list;

public class Eggplant extends Food {
    private final FoodType type = FoodType.VEGETABLE;

    public Eggplant(String name) {
        super(name);
    }

    @Override
    public FoodType getFoodType() {
        return type;
    }
}
