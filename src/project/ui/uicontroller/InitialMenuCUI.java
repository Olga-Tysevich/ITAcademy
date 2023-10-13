package project.ui.uicontroller;

import project.ui.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InitialMenuCUI implements InitialMenuUI {
    RequisitesUI requisitesUI = new RequisitesCUI();
    BankAccountUI bankAccountUI = new BankAccountCUI();

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
    public RequisitesUI requisites() {
        return requisitesUI;
    }

    @Override
    public BankAccountUI bankAccount() {
        return bankAccountUI;
    }




    @Override
    public int getUserChoice() {
        int userChoice;
        while (true) {
            System.out.println("Выберите действие: ");
            try {
                userChoice = new Scanner(System.in).nextInt();
                if (userChoice > 0 && userChoice < 6) {
                    break;
                } else {
                    System.out.println("Пожалуйства введите корректные данные");
                }
            } catch (InputMismatchException e) {
                System.out.println((e.getMessage()));
            }
        }
        switch (userChoice) {
            case 1 -> {
                return REQUISITES_CHOICE;
            }
            case 2 -> {
                return BANK_ACCOUNTS_CHOICE;
            }
            case 3 -> {
                return CUSTOMERS_CHOICE;
            }
            case 4 -> {
                return RECYCLABLE_UNITS_CHOICE;
            }
            case 5 -> {
                return EXIT_CHOICE;
            }
        }
        return -1;
    }

}