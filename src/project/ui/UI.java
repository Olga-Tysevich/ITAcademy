package project.ui;

import project.model.requisites.BankAccount;
import project.model.requisites.Requisites;
import java.util.Date;
import java.util.List;

public interface UI {
    void displayInitialMenu(String ownerName);
    void displayRequisites(Requisites requisites);
    void displayBankAccount(BankAccount bankAccount);

    //void display....

    <E> void displayList(List<E> entryList);
    int getIntFromUser();
    double getDoubleFromUser();
    String getDataFromUser();
    Date getDateFromUser();
}
