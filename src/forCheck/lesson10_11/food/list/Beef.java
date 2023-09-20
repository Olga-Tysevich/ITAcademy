package forCheck.lesson10_11.food.list;

public class Beef extends Food {
    private final FoodType type = FoodType.MEAT;

    public Beef(String name) {
        super(name);
    }

    @Override
    public FoodType getFoodType() {
        return type;
    }

}
