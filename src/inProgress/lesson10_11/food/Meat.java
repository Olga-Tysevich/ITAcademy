package inProgress.lesson10_11.food;

public class Meat extends Food{

    public Meat(String name) {
        super(name);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.MEAT;
    }

}
