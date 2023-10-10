package project;

import project.database.SQLDB;
import project.model.Company;
import project.model.Owner;
import project.model.recyclableUnits.RecyclableUnit;
import project.model.requisites.BankAccount;
import project.model.requisites.Requisites;
import project.database.DB;
import project.ui.ConsoleUI;
import project.ui.UI;
import java.util.ArrayList;
import java.util.List;

public class Handler {
    Owner owner;
    private UI ui;
    private final DB db;

    public Handler() {
        db = new SQLDB();
        updateOwnerData();
        ui = new ConsoleUI();
    }

    public static void main(String[] args) {
        Handler handler = new Handler();
        handler.start();
    }

    private void start() {
        while (true) {
            ui.displayInitialMenu(owner.getOwnerRequisites().getNameForPrint());
            switch (ui.getIntFromUser()) {
                case 1 -> changeRequisites(owner, owner.getOwnerRequisites());
                case 2 -> {
                    String userChoice = changeCatalog(DataType.BANK_ACCOUNT, owner);
                    if (userChoice.equals("new") ) {
                        changeBankAccount(owner, createNew(DataType.BANK_ACCOUNT, owner));
                    } else if (userChoice.equals("id")) {
                        ui.displayList(owner.getOwnerBankAccounts());
                        changeBankAccount(owner, db.select(DataType.BANK_ACCOUNT, ui.getIntFromUser()));
                    }
                }
                case 5 -> {
                    return;
                }
            }
        }
    }

    private <E extends Company> String changeCatalog(DataType dataType, E company) {
        switch (dataType) {
            case REQUISITES -> ui.displayList(company.getRequisitesList());
            case BANK_ACCOUNT -> ui.displayList(company.getBankAccounts());
        }
        return ui.getDataFromUser();
    }

    @SuppressWarnings("unchecked")
    private <E extends Company, O> O createNew(DataType dataType, E company) {
        switch (dataType) {
            case REQUISITES -> {
                return (O) new Requisites(db.getID(DataType.REQUISITES), company.getID());
            }
            case BANK_ACCOUNT -> {
                return (O) new BankAccount(db.getID(DataType.BANK_ACCOUNT), company.getID());
            }
        }
        return null;
    }

    private <E extends Company> void changeRequisites(E company, Requisites requisites) {
        while (true) {
            ui.displayRequisites(requisites);
            int userChoice = ui.getIntFromUser();
            if (userChoice == 7) {
                addToDB(DataType.REQUISITES, requisites.getID(), requisites);
                return;
            } else if (userChoice == 8) {
                company.removeRequisites(requisites);
                company.addRequisites(db.select(DataType.REQUISITES, requisites.getID()));
                return;
            } else {
                requisites.setData(userChoice, ui.getDataFromUser());
            }
        }
    }

    private <E extends Company> void changeBankAccount(E company, BankAccount bankAccount) {
        while (true) {
            ui.displayBankAccount(bankAccount);
            int userChoice = ui.getIntFromUser();
            if (userChoice == 5) {
                addToDB(DataType.BANK_ACCOUNT, bankAccount.getID(), bankAccount);
                return;
            } else if (userChoice == 6) {
                company.removeBankAccount(bankAccount);
                company.addBankAccount(db.select(DataType.BANK_ACCOUNT, bankAccount.getID()));
                return;
            } else {
                bankAccount.setData(userChoice, ui.getDataFromUser());
            }
        }
    }

    private void updateOwnerData() {
        Requisites requisites = db.select(DataType.REQUISITES, 1) != null ? db.select(DataType.REQUISITES, 1) : new Requisites(1, 1);
        List<BankAccount> bankAccounts = db.selectAll(DataType.BANK_ACCOUNT, 1) != null ? db.selectAll(DataType.BANK_ACCOUNT, 1)
                : new ArrayList<>();
        List<RecyclableUnit> recyclableUnits = db.selectAll(DataType.RECYCLABLE_UNIT) != null ? db.selectAll(DataType.RECYCLABLE_UNIT) : new ArrayList<>();
        owner = new Owner(requisites, bankAccounts, recyclableUnits);
    }

    public <E> void addToDB(DataType dataType, int ID, E entry) {
        if (db.select(dataType, ID) != null) {
            db.update(entry);
        } else {
            db.insert(entry);
        }
    }

}
