package forCheck.lesson10_11.food.list;

public abstract class Food {
    private String name;

    public Food(String name) {
        this.name = name;
    }

    public abstract FoodType getFoodType();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}