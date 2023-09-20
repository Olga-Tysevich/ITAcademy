package forCheck.lesson10_11.food.list;

public class Mango extends Food {
    private final FoodType type = FoodType.FRUIT;
    public Mango(String name) {
        super(name);
    }

    @Override
    public FoodType getFoodType() {
        return type;
    }
}
