package project.ui;

import project.model.requisites.BankAccount;
import project.model.requisites.Requisites;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ConsoleUI implements UI {
    @Override
    public void displayInitialMenu(String ownerName) {
        System.out.println(ownerName);
        System.out.println("1) Реквизиты");
        System.out.println("2) Банковские аккаунты");
        System.out.println("3) Заказчики");
        System.out.println("4) Список утиля");
        System.out.println("5) Выход");
    }

    @Override
    public void displayRequisites(Requisites requisites) {
        System.out.println("Название: " + requisites.getNameForPrint() + ": 1 - изменить название");
        System.out.println("УНН: " + requisites.getTaxpayerID() + ": 2 - изменить УНН");
        System.out.println("ОКПО: " + requisites.getClassifierCode() + ": 3 - изменить ОКПО");
        System.out.println("Юр. адрес: " + requisites.getLegalAddress() + ": 4 - изменить юр. адрес");
        System.out.println("Почтовый адрес: " + requisites.getMailingAddress() + ": 5 - изменить почтовый адрес");
        System.out.println("Телефон: " + requisites.getPhone() + ": 6 - изменить телефон");
        System.out.println("7 - Сохранить и выйти");
        System.out.println("8 - Отменить");
    }

    @Override
    public void displayBankAccount(BankAccount bankAccount) {
        System.out.println("Название банка: " + bankAccount.getBankName() + ": 1 - именить название банка");
        System.out.println("Номер счета: " + bankAccount.getAccountNumber() + ": 2 - изменить номер счета");
        System.out.println("BIC: " + bankAccount.getBIC() + ": 3 - изменить BIC");
        System.out.println("Адрес банка: " + bankAccount.getBankAddress() + ": 4 - изменить адрес банка");
        System.out.println("5 - Сохранить и выйти");
        System.out.println("6 - Отменить");
    }

    @Override
    public <E> void displayList(List<E> entryList) {
        entryList.forEach(System.out::println);
        System.out.println(": new - добавить новый:");
        System.out.println(": id - выбрать по ID");
        System.out.println(": cancel - Отменить");
    }

    @Override
    public int getIntFromUser() {
        int userChoice;
        while (true) {
            System.out.println("Введите целое число: ");
            try {
                userChoice = new Scanner(System.in).nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Пожалуйства введите корректные данные");
            }
        }
        return userChoice;
    }

    @Override
    public double getDoubleFromUser() {
        double userChoice;
        while (true) {
            System.out.println("Введите число: ");
            try {
                userChoice = new Scanner(System.in).nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Пожалуйства введите корректные данные");
            }
        }

        return userChoice;
    }


    @Override
    public String getDataFromUser() {
        String userChoice;
        System.out.println("Введите данные: ");
        userChoice = new Scanner(System.in).nextLine();
        return userChoice;
    }

    @Override
    public Date getDateFromUser() {
        String date = new Scanner(System.in).nextLine();
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        Date contractDate = null;
        System.out.println("Введите дату в формате: дд.мм.гггг");
        try {
            contractDate = format.parse(date);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return contractDate;
    }

}