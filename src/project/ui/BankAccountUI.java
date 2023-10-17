package project.ui;

import project.model.requisites.BankAccount;
import java.util.List;

public interface BankAccountUI {
    BankAccount changeBankAccount(BankAccount bankAccount);
    int getBankAccountId(List<BankAccount> bankAccounts);

}
