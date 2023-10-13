package project;

import project.database.dbcontroller.SQLDB;
import project.model.requisites.BankAccount;
import project.model.requisites.Requisites;
import project.database.DB;
import project.ui.*;
import project.ui.uicontroller.InitialMenuCUI;

public class Controller {
    private final int OWNER_ID = 1;
    private final int OWNER_REQUISITES_ID = 1;
    private final InitialMenuUI initialMenuUI;
    private final DB db;

    public Controller() {
        db = new SQLDB();
        initialMenuUI = new InitialMenuCUI();
        if (db.selectRequisites(OWNER_REQUISITES_ID) == null) {
            addToDB(OWNER_ID, new Requisites(OWNER_ID));
        }
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.start();
    }

    private void start() {
        while (true) {
            initialMenuUI.displayInitialMenu(db.selectRequisites(OWNER_REQUISITES_ID).getNameForPrint());
            switch (initialMenuUI.getUserChoice()) {
                case InitialMenuUI.REQUISITES_CHOICE -> changeRequisites(db.selectRequisites(OWNER_REQUISITES_ID));
                case InitialMenuUI.BANK_ACCOUNTS_CHOICE -> manageBankAccounts(OWNER_ID);
                case InitialMenuUI.EXIT_CHOICE -> {
                    return;
                }
            }
        }
    }

    private void manageBankAccounts(int owner_id) {
        BankAccountUI bankAccountUI = initialMenuUI.bankAccount();
        bankAccountUI.displayBankAccountList(db.selectBankAccounts(owner_id));
        DataListMenuUI dataListMenuUI = bankAccountUI.dataListMenu();
        while (true) {
            dataListMenuUI.displayListMenu();
            switch (dataListMenuUI.getUserChoice()) {
                case DataListMenuUI.CREATE_NEW_OBJECT_CHOICE -> changeBankAccount(new BankAccount(owner_id));
                case DataListMenuUI.SELECT_OBJECT_CHOICE -> {
                    bankAccountUI.displayBankAccountList(db.selectBankAccounts(owner_id));
                    int userChoice = bankAccountUI.getBankAccountId(db.selectBankAccounts(owner_id).size());
                    changeBankAccount(db.selectBankAccount(userChoice));
                }
                case DataListMenuUI.CANCEL_CHOICE -> {
                    return;
                }
            }
        }
    }

    private void changeRequisites(Requisites requisites) {
        while (true) {
            RequisitesUI requisitesUI = initialMenuUI.requisites();
            requisitesUI.displayRequisitesData(requisites);
            switch (requisitesUI.getUserChoice()) {
                case RequisitesUI.CHANGE_COMPANY_NAME_CHOICE ->
                        requisites.setNameForPrint(requisitesUI.getCompanyNameFromUser());
                case RequisitesUI.CHANGE_TAXPAYER_ID_CHOICE ->
                        requisites.setTaxpayerID(requisitesUI.getTaxpayerIdFromUser());
                case RequisitesUI.CHANGE_CLASSIFIER_CODE_CHOICE ->
                        requisites.setClassifierCode(requisitesUI.getClassifierCodeFromUser());
                case RequisitesUI.CHANGE_LEGAL_ADDRESS_CHOICE ->
                        requisites.setLegalAddress(requisitesUI.getLegalAddressFromUser());
                case RequisitesUI.CHANGE_MAILING_ADDRESS_CHOICE ->
                        requisites.setMailingAddress(requisitesUI.getMailingAddressFromUser());
                case RequisitesUI.CHANGE_PHONE_CHOICE -> requisites.setPhone(requisitesUI.getPhoneFromUser());
                case RequisitesUI.SAVE_CHOICE -> {
                    addToDB(requisites.getId(), requisites);
                    return;
                }
                case RequisitesUI.CANCEL_CHOICE -> {
                    return;
                }
            }
        }
    }

    private void changeBankAccount(BankAccount bankAccount) {
        while (true) {
            BankAccountUI bankAccountUI = initialMenuUI.bankAccount();
            bankAccountUI.displayBankAccount(bankAccount);
            switch (bankAccountUI.getUserChoice()) {
                case BankAccountUI.BANK_NAME_CHOICE -> bankAccount.setBankName(bankAccountUI.getBankNameFromUser());
                case BankAccountUI.ACCOUNT_NUMBER_CHOICE ->
                        bankAccount.setAccountNumber(bankAccountUI.getAccountNumberFromUser());
                case BankAccountUI.BIC_CHOICE -> bankAccount.setBankAddress(bankAccountUI.getBICFromUser());
                case BankAccountUI.BANK_ADDRESS_CHOICE ->
                        bankAccount.setBankAddress(bankAccountUI.getBankAddressFromUser());
                case BankAccountUI.SAVE_CHOICE -> {
                    addToDB(bankAccount.getId(), bankAccount);
                    return;
                }
                case BankAccountUI.CANCEL_CHOICE -> {
                    return;
                }
            }
        }
    }

    public <E> void addToDB(int id, E entry) {
        if (db.selectRequisites(id) != null) {
            db.update(entry);
        } else {
            db.insert(entry);
        }
    }
}