package checked.lesson6.Task2;

public class Phone {
    private String number;
    private final String model;
    private double weight;

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone(String number, String model, double weight) {
        this(number, model);
        this.weight = weight;
    }

    public void receiveCall(String callerName) {
        System.out.println("На телефон " + model + " с номером " + number + " звонит " + callerName);
    }

    public void receiveCall(String callerName, String callerPhone) {
        System.out.println("На телефон " + model + " с номером " + number + " звонит " + callerName + " с номера " + callerPhone);
    }

    public void sendMessage(String... recipientPhoneNumbers) {
        for (String recipientPhoneNumber : recipientPhoneNumbers) {
            System.out.println("Сообщение с номера " + number + " отправлено на номер " + recipientPhoneNumber);
        }
    }

    public void changeNumber(String number) {
        this.number = number;
    }

    public void changeWeight(double weight) {
        this.weight = weight;
    }

    public String getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public double getWeight() {
        return weight;
    }
}
