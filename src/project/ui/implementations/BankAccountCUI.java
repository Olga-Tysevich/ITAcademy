package project.ui.implementations;

import project.model.requisites.BankAccount;
import project.ui.BankAccountUI;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static project.ui.Constants.*;

public class BankAccountCUI implements BankAccountUI {

    @Override
    public BankAccount changeBankAccount(BankAccount bankAccount) {
        BankAccount temp =new BankAccount(bankAccount.getId(), bankAccount.getOWNER_ID(),bankAccount.getBankName(),bankAccount.getAccountNumber(),
                bankAccount.getBIC(), bankAccount.getBankAddress());
        System.out.println("Название банка: " + temp.getBankName() + ": 1 - именить название банка");
        System.out.println("Номер счета: " + temp.getAccountNumber() + ": 2 - изменить номер счета");
        System.out.println("BIC: " + temp.getBIC() + ": 3 - изменить BIC");
        System.out.println("Адрес банка: " + temp.getBankAddress() + ": 4 - изменить адрес банка");
        System.out.println("5 - Сохранить");
        System.out.println("6 - Отменить");

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
            case 1 -> temp.setBankName(getBankNameFromUser());
            case 2 -> temp.setAccountNumber(getAccountNumberFromUser());
            case 3 -> temp.setBankAddress(getBICFromUser());
            case 4 -> temp.setBankAddress(getBankAddressFromUser());
            case 5 -> {
                return temp;
            }
            case 6 -> {
                return bankAccount;
            }
        }
        return bankAccount;
    }

    @Override
    public int getBankAccountId(List<BankAccount> bankAccounts) {
        if (bankAccounts != null) {
            bankAccounts.forEach(System.out::println);
            int userChoice;
            while (true) {
                System.out.println("Введите id аккаунта: ");
                try {
                    userChoice = new Scanner(System.in).nextInt();
                    if (userChoice > 0 && userChoice <= bankAccounts.size()) {
                        return userChoice;
                    } else {
                        System.out.println("Пожалуйства введите корректные данные");
                    }
                } catch (InputMismatchException e) {
                    System.out.println((e.getMessage()));
                }
            }
        } else {
            System.out.println("Нет доступных аккаунтов");
        }
        return NO_DATA;
    }

    private String getBankNameFromUser() {
        System.out.println("Введите название банка:");
        return getDataFromUser();
    }

    private String getAccountNumberFromUser() {
        System.out.println("Введите номер счета:");
        return getDataFromUser();
    }

    private String getBICFromUser() {
        System.out.println("Введите BIC:");
        return getDataFromUser();
    }

    private String getBankAddressFromUser() {
        System.out.println("Введите адрес банка:");
        return getDataFromUser();
    }

    private String getDataFromUser() {
        String userChoice;
        System.out.println("Вводите данные: ");
        userChoice = new Scanner(System.in).nextLine();
        return userChoice;
    }
}
