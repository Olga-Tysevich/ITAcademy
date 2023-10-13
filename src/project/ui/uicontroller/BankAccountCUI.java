package project.ui.uicontroller;

import project.model.requisites.BankAccount;
import project.ui.BankAccountUI;
import project.ui.DataListMenuUI;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BankAccountCUI implements BankAccountUI {
    DataListMenuUI dataListMenuUI;

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
    public int getUserChoice() {
        int userChoice;
        while (true) {
            System.out.println("Выберите действие: ");
            try {
                userChoice = new Scanner(System.in).nextInt();
                if (userChoice > 0 && userChoice < 7) {
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
                return BANK_NAME_CHOICE;
            }
            case 2 -> {
                return ACCOUNT_NUMBER_CHOICE;
            }
            case 3 -> {
                return BIC_CHOICE;
            }
            case 4 -> {
                return BANK_ADDRESS_CHOICE;
            }
            case 5 -> {
                return SAVE_CHOICE;
            }
            case 6 -> {
                return CANCEL_CHOICE;
            }
        }
        return -1;
    }

    @Override
    public String getBankNameFromUser() {
        System.out.println("Введите название банка:");
        return getDataFromUser();
    }

    @Override
    public String getAccountNumberFromUser() {
        System.out.println("Введите номер счета:");
        return getDataFromUser();
    }

    @Override
    public String getBICFromUser() {
        System.out.println("Введите BIC:");
        return getDataFromUser();
    }

    @Override
    public String getBankAddressFromUser() {
        System.out.println("Введите адрес банка:");
        return getDataFromUser();
    }

    @Override
    public void displayBankAccountList(List<BankAccount> bankAccounts) {
        bankAccounts.forEach(System.out::println);
    }

    @Override
    public int getBankAccountId(int listSize) {
        int userChoice;
        while (true) {
            System.out.println("Введите id аккаунта: ");
            try {
                userChoice = new Scanner(System.in).nextInt();
                if (userChoice > 0 && userChoice <= listSize) {
                    return userChoice;
                } else {
                    System.out.println("Пожалуйства введите корректные данные");
                }
            } catch (InputMismatchException e) {
                System.out.println((e.getMessage()));
            }
        }
    }

    @Override
    public DataListMenuUI dataListMenu() {
        return dataListMenuUI;
    }

    private String getDataFromUser() {
        String userChoice;
        System.out.println("Вводите данные: ");
        userChoice = new Scanner(System.in).nextLine();
        return userChoice;
    }
}
