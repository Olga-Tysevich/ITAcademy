package project.ui.uicontroller;

import project.model.requisites.Requisites;
import project.ui.DataListMenuUI;
import project.ui.RequisitesUI;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RequisitesCUI implements RequisitesUI {
    DataListMenuUI dataListMenuUI;
    @Override
    public void displayRequisitesData(Requisites requisites) {
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
    public int getUserChoice() {
        int userChoice;
        while (true) {
            System.out.println("Выберите действие: ");
            try {
                userChoice = new Scanner(System.in).nextInt();
                if (userChoice > 0 && userChoice < 9) {
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
                return CHANGE_COMPANY_NAME_CHOICE;
            }
            case 2 -> {
                return CHANGE_TAXPAYER_ID_CHOICE;
            }
            case 3 -> {
                return CHANGE_CLASSIFIER_CODE_CHOICE;
            }
            case 4 -> {
                return CHANGE_LEGAL_ADDRESS_CHOICE;
            }
            case 5 -> {
                return CHANGE_MAILING_ADDRESS_CHOICE;
            }
            case 6 -> {
                return CHANGE_PHONE_CHOICE;
            }
            case 7 -> {
                return SAVE_CHOICE;
            }
            case 8 -> {
                return CANCEL_CHOICE;
            }
        }
        return -1;
    }

    @Override
    public String getCompanyNameFromUser() {
        String userChoice;
        System.out.println("Введите название: ");
        userChoice = new Scanner(System.in).nextLine();
        return userChoice;
    }

    @Override
    public int getTaxpayerIdFromUser() {
        int userChoice;
        System.out.println("Введите УНН: ");
        userChoice = new Scanner(System.in).nextInt();
        return userChoice;
    }

    @Override
    public int getClassifierCodeFromUser() {
        int userChoice;
        System.out.println("Введите ОКПО: ");
        userChoice = new Scanner(System.in).nextInt();
        return userChoice;
    }

    @Override
    public String getLegalAddressFromUser() {
        String userChoice;
        System.out.println("Введите юр. адрес: ");
        userChoice = new Scanner(System.in).nextLine();
        return userChoice;
    }

    @Override
    public String getMailingAddressFromUser() {
        String userChoice;
        System.out.println("Введите почтовый адрес: ");
        userChoice = new Scanner(System.in).nextLine();
        return userChoice;
    }

    @Override
    public String getPhoneFromUser() {
        String userChoice;
        System.out.println("Введите телефон: ");
        userChoice = new Scanner(System.in).nextLine();
        return userChoice;
    }

    @Override
    public void displayRequisitesList(List<Requisites> requisites) {
        requisites.forEach(System.out::println);
    }

    @Override
    public DataListMenuUI dataListMenu() {
        return dataListMenuUI;
    }

    @Override
    public int getRequisitesId(int listSize) {
        int userChoice;
        while (true) {
            System.out.println("Введите id реквизитов: ");
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
}
