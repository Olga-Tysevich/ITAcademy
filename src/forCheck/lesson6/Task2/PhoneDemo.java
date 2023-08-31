package forCheck.lesson6.Task2;

public class PhoneDemo {
    public static void main(String[] args) {
        //task #2
        Phone teXet = new Phone("+375 (29) 111-11-11", "TeXet", 275);
        Phone philips = new Phone("+375 (33) 123-12-13", "Philips", 185);
        philips.changeNumber("+375 (33) 223-12-13");
        Phone xiaomi = new Phone("+375 (44) 321-21-31", "Xiaomi");
        xiaomi.changeWeight(375.12);

        System.out.println("Телефон " + teXet.getModel() + " с номером " + teXet.getNumber() + " и весом " + teXet.getWeight());
        System.out.println("Телефон " + philips.getModel() + " с номером " + philips.getNumber() + " и весом " + philips.getWeight());
        System.out.println("Телефон " + xiaomi.getModel() + " с номером " + xiaomi.getNumber() + " и весом " + xiaomi.getWeight());
        System.out.println();

        teXet.receiveCall("Мама");
        philips.receiveCall("Папа");
        xiaomi.receiveCall("Сестра");
        System.out.println();

        teXet.receiveCall("Мама", "+375 (44) 321-56-56");
        philips.receiveCall("Папа", "+375 (29) 151-26-96");
        xiaomi.receiveCall("Сестра", "+375 (33) 263-52-63");
        System.out.println();

        teXet.sendMessage("+375 (29) 123-45-67", "+375 (29) 985-56-12");
        System.out.println();
        philips.sendMessage("+375 (25) 685-54-61", "+375 (33) 601-43-43", "+375 (25) 956-87-31");
        System.out.println();
        xiaomi.sendMessage("+375 (29) 256-13-13", "+375 (44) 908-43-48", "+375 (25) 956-17-11", "+375 (29) 295-87-07");
    }
}
