package project.ui.implementations;

import project.model.requisites.Requisites;
import project.ui.RequisitesUI;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static project.ui.Constants.*;

public class RequisitesCUI implements RequisitesUI {

    @Override
    public Requisites changeRequisites(Requisites requisites) {
        Requisites temp = new Requisites(requisites.getId(), requisites.getOWNER_ID(), requisites.getNameForPrint(), requisites.getTaxpayerID(),
                requisites.getClassifierCode(), requisites.getLegalAddress(), requisites.getMailingAddress(), requisites.getPhone());

        while (true) {
            System.out.println("Название: " + temp.getNameForPrint() + ": 1 - изменить название");
            System.out.println("УНН: " + temp.getTaxpayerID() + ": 2 - изменить УНН");
            System.out.println("ОКПО: " + temp.getClassifierCode() + ": 3 - изменить ОКПО");
            System.out.println("Юр. адрес: " + temp.getLegalAddress() + ": 4 - изменить юр. адрес");
            System.out.println("Почтовый адрес: " + temp.getMailingAddress() + ": 5 - изменить почтовый адрес");
            System.out.println("Телефон: " + temp.getPhone() + ": 6 - изменить телефон");
            System.out.println("7 - Сохранить");
            System.out.println("8 - Отменить");
            System.out.println("Выберите действие: ");
            int userChoice;
            while (true) {
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
                case 1 -> temp.setNameForPrint(getCompanyNameFromUser());
                case 2 -> temp.setTaxpayerID(getTaxpayerIdFromUser());
                case 3 -> temp.setClassifierCode(getClassifierCodeFromUser());
                case 4 -> temp.setLegalAddress(getLegalAddressFromUser());
                case 5 -> temp.setMailingAddress(getMailingAddressFromUser());
                case 6 -> temp.setPhone(getPhoneFromUser());
                case 7 -> {
                    return temp;
                }
                case 8 -> {
                    return requisites;
                }
            }
        }
    }

    @Override
    public int getRequisitesId(List<Requisites> requisites) {
        if (requisites != null) {
            requisites.forEach(System.out::println);
            int userChoice;
            while (true) {
                System.out.println("Введите id реквизитов: ");
                try {
                    userChoice = new Scanner(System.in).nextInt();
                    if (userChoice > 0 && userChoice <= requisites.size()) {
                        return userChoice;
                    } else {
                        System.out.println("Пожалуйства введите корректные данные");
                    }
                } catch (InputMismatchException e) {
                    System.out.println((e.getMessage()));
                }
            }
        } else {
            System.out.println("Нет созданных реквизитов!");
            return NO_DATA;
        }

    }

    private String getCompanyNameFromUser() {
        String userChoice;
        System.out.println("Введите название: ");
        userChoice = new Scanner(System.in).nextLine();
        return userChoice;
    }


    private int getTaxpayerIdFromUser() {
        int userChoice;
        System.out.println("Введите УНН: ");
        userChoice = new Scanner(System.in).nextInt();
        return userChoice;
    }


    private int getClassifierCodeFromUser() {
        int userChoice;
        System.out.println("Введите ОКПО: ");
        userChoice = new Scanner(System.in).nextInt();
        return userChoice;
    }


    private String getLegalAddressFromUser() {
        String userChoice;
        System.out.println("Введите юр. адрес: ");
        userChoice = new Scanner(System.in).nextLine();
        return userChoice;
    }


    private String getMailingAddressFromUser() {
        String userChoice;
        System.out.println("Введите почтовый адрес: ");
        userChoice = new Scanner(System.in).nextLine();
        return userChoice;
    }


    private String getPhoneFromUser() {
        String userChoice;
        System.out.println("Введите телефон: ");
        userChoice = new Scanner(System.in).nextLine();
        return userChoice;
    }


}
