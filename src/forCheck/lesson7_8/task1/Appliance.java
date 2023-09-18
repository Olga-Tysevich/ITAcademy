package forCheck.lesson7_8.task1;

public abstract class Appliance {
    private final String type;
    private final String brand;
    private final double amperage;
    private boolean isOn = false;
    private final boolean hasElectricMotor;
    private double power = 0;
    private String location;

    public Appliance(Vacuum vacuum, String location, String type, String brand, double amperage, boolean hasElectricMotor) {
        this.type = type;
        this.brand = brand;
        this.amperage = amperage;
        this.hasElectricMotor = hasElectricMotor;
        this.location = location;
        vacuum.addAppliance(this);
    }

    public Appliance(Vacuum vacuum, String location, String type, String brand, double amperage, boolean hasElectricMotor, boolean isOn) {
        this.type = type;
        this.brand = brand;
        this.amperage = amperage;
        this.isOn = isOn;
        this.hasElectricMotor = hasElectricMotor;
        this.location = location;
        vacuum.addAppliance(this);
    }

    public void changeState() {
        this.isOn = !this.isOn;
        if (isOn) {
            calculatePower();
        }
    }

    public void calculatePower() {
        //P = I * U / PowerFactor (При отсутствии данных допустимо принять cos(φ) в пределах 0,7-0,8);
        //Холодильники, стиральные машины, дрели и прочее оборудование с электродвигателями;
        int MAINS_VOLTAGE = 220;
        if (hasElectricMotor && isOn) {
            double POWER_FACTOR = 0.7;
            power = amperage * MAINS_VOLTAGE / POWER_FACTOR;
        } else if (isOn) {
            power = amperage * MAINS_VOLTAGE;
        } else {
            power = 0;
        }
    }

    @Override
    public String toString() {
        return "{" +
                "location: " + location +
                ", type: " + type +
                ", brand: " + brand +
                ", amperage: " + amperage +
                ", power: " + String.format("%.2f", power);
    }

    public static void printArrayOfAppliances(Appliance[] arrayOfAppliances) {
        if (arrayOfAppliances != null) {
            System.out.println("Appliances array: {");
            for (Appliance appliance : arrayOfAppliances) {
                System.out.println(appliance.toString());
            }
            System.out.println("};\n");
        } else {
            System.out.println("There is no appliances in the house!");
        }
    }

    public void changeLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public double getAmperage() {
        return amperage;
    }

    public boolean isOn() {
        return isOn;
    }

    public double getPower() {
        return power;
    }

    public boolean getState() {
        return isOn;
    }

}
