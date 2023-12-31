package lesson10_11_Generics_Enum.food;

public enum FoodType {
    MEAT(false),
    FISH(false),
    FRUIT(true),
    VEGETABLE(true),
    MILK(false),
    UNKNOWN;

    private boolean isVegetarian;

    FoodType(boolean isVegetarian) {
        this.isVegetarian = isVegetarian;
    }

    FoodType() {
    }

    public boolean isVegetarian(){
        return isVegetarian;
    }
}
