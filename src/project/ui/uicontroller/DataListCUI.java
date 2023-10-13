package project.ui.uicontroller;

import project.ui.DataListMenuUI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataListCUI implements DataListMenuUI {
    @Override
    public void displayListMenu() {
        System.out.println(": new - добавить новый");
        System.out.println(": select - выбрать по ID");
        System.out.println(": cancel - Отменить");
    }

    @Override
    public String getUserChoice() {
        String userChoice;
        while (true) {
            System.out.println("Выберите действие: ");
            try {
                userChoice = new Scanner(System.in).nextLine();
                if (userChoice.equals("new") || userChoice.equals("select") || userChoice.equals("cancel")) {
                    break;
                } else {
                    System.out.println("Пожалуйства введите корректные данные");
                }
            } catch (InputMismatchException e) {
                System.out.println((e.getMessage()));
            }
        }
        switch (userChoice) {
            case "new" -> {
                return DataListMenuUI.CREATE_NEW_OBJECT_CHOICE;
            }
            case "select" -> {
                return DataListMenuUI.SELECT_OBJECT_CHOICE;
            }
            case "cancel" -> {
                return DataListMenuUI.CANCEL_CHOICE;
            }
        }
        return null;
    }
}
