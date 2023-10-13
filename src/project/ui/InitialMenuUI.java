package project.ui;

public interface InitialMenuUI {
    int REQUISITES_CHOICE = 1;
    int BANK_ACCOUNTS_CHOICE = 2;
    int CUSTOMERS_CHOICE = 3;
    int RECYCLABLE_UNITS_CHOICE = 4;
    int EXIT_CHOICE = 5;
    void displayInitialMenu(String ownerName);
    RequisitesUI requisites();
    BankAccountUI bankAccount();
    int getUserChoice();
}
