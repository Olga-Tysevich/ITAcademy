package project.ui;

import project.model.requisites.BankAccount;
import java.util.List;

public interface BankAccountUI {
    int BANK_NAME_CHOICE = 1;
    int ACCOUNT_NUMBER_CHOICE = 2;
    int BIC_CHOICE = 3;
    int BANK_ADDRESS_CHOICE = 4;
    int SAVE_CHOICE = 5;
    int CANCEL_CHOICE = 6;

    void displayBankAccount(BankAccount bankAccount);
    int getUserChoice();
    String getBankNameFromUser();
    String getAccountNumberFromUser();
    String getBICFromUser();
    String getBankAddressFromUser();
    void displayBankAccountList(List<BankAccount> bankAccounts);
    DataListMenuUI dataListMenu();
    int getBankAccountId(int listSize);

}
