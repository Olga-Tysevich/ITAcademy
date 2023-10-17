package project.ui;

public interface InitialMenuUI {

    void displayInitialMenu(String ownerName);
    RequisitesUI requisites();
    BankAccountUI bankAccount();
    CustomerUI customer();
    RecyclableUnitUI recyclableUnit();
    int getUserChoice();
}
