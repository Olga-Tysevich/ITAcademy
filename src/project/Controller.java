package project;

import project.model.Owner;
import project.model.customer.Bill;
import project.model.customer.Contract;
import project.model.customer.Customer;
import project.model.customer.WayBill;
import project.model.recyclableUnits.RecyclableType;
import project.model.recyclableUnits.RecyclableUnit;
import project.model.requisites.BankAccount;
import project.model.requisites.Requisites;
import project.database.DB;
import project.ui.*;
import project.ui.implementations.DataListMenuCUI;
import project.ui.implementations.InitialMenuCUI;

import java.util.List;
import java.util.Map;

import static project.ui.Constants.*;

public class Controller {
    Owner owner = new Owner();
    private final InitialMenuUI initialMenuUI;
    private final DataListMenuUI dataListMenuUi;
    private DB db;

    public Controller() {
        initialMenuUI = new InitialMenuCUI();
        dataListMenuUi = new DataListMenuCUI();
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.start();
    }

    private void start() {
        while (true) {
            updateOwnerData();
            initialMenuUI.displayInitialMenu(owner.getRequisites().getNameForPrint());
            switch (initialMenuUI.getUserChoice()) {
                case REQUISITES_CHOICE -> changeRequisites(owner.getRequisites());
                case BANK_ACCOUNTS_CHOICE -> manageBankAccounts(owner.getID());
                case CUSTOMERS_CHOICE -> manageCustomers();
                case RECYCLABLE_UNITS_CHOICE -> manageRecyclableUnits();
                case EXIT_CHOICE -> {
                    return;
                }
            }
        }
    }

    private void manageRequisites(int ownerId) {
        RequisitesUI requisitesUI = initialMenuUI.requisites();
        while (true) {
            dataListMenuUi.displayListMenu();
            switch (dataListMenuUi.getUserChoice()) {
                case CREATE_NEW_OBJECT_CHOICE -> changeRequisites(new Requisites(ownerId));
                case SELECT_OBJECT_CHOICE -> {
                    int userChoice = requisitesUI.getRequisitesId(db.selectAll(ownerId));
                    if (userChoice != NO_DATA) {
                        changeRequisites(db.select(userChoice));
                    }
                }
                case LIST_MENU_CANCEL_CHOICE -> {
                    return;
                }
            }
        }
    }

    private void changeRequisites(Requisites requisites) {
        RequisitesUI requisitesUI = initialMenuUI.requisites();
        Requisites temp = requisitesUI.changeRequisites(requisites);
        if (requisites != temp && db.select(requisites.getId()) != null) {
            db.update(temp);
        } else if (requisites != temp) {
            db.insert(temp);
        }
    }

    private void manageBankAccounts(int companyId) {
        BankAccountUI bankAccountUI = initialMenuUI.bankAccount();
        while (true) {
            dataListMenuUi.displayListMenu();
            switch (dataListMenuUi.getUserChoice()) {
                case CREATE_NEW_OBJECT_CHOICE -> changeBankAccount(new BankAccount(companyId));
                case SELECT_OBJECT_CHOICE -> {
                    int userChoice = bankAccountUI.getBankAccountId(db.selectAll(companyId));
                    if (userChoice != NO_DATA) {
                        changeBankAccount(db.select(userChoice));
                    }
                }
                case LIST_MENU_CANCEL_CHOICE -> {
                    return;
                }
            }
        }
    }

    private void changeBankAccount(BankAccount bankAccount) {
        BankAccountUI bankAccountUI = initialMenuUI.bankAccount();
        BankAccount temp = bankAccountUI.changeBankAccount(bankAccount);
        if (bankAccount != temp && db.select(bankAccount.getId()) != null) {
            db.update(temp);
        } else if (bankAccount != temp) {
            db.insert(temp);
        }
    }

    private void manageCustomers() {
        CustomerUI customerUI = initialMenuUI.customer();
        while (true) {
            dataListMenuUi.displayListMenu();
            switch (dataListMenuUi.getUserChoice()) {
                case CREATE_NEW_OBJECT_CHOICE -> {
                    Customer customer = new Customer(customerUI.getCustomerNameFromUser());
                    db.insert(customer);
                    changeCustomer(customer);
                }
                case SELECT_OBJECT_CHOICE -> {
                    int userChoice = customerUI.getCustomerId(db.selectAll());
                    if (userChoice != NO_DATA) {
                        changeCustomer(db.select(userChoice));
                    }
                }
                case LIST_MENU_CANCEL_CHOICE -> {
                    return;
                }
            }
        }
    }

    private void changeCustomer(Customer customer) {
        while (true) {
            CustomerUI customerUI = initialMenuUI.customer();
            customerUI.displayCustomer(customer);
            switch (customerUI.getUserChoice()) {
                case NAME_CHOICE -> customer.setName(customerUI.getCustomerNameFromUser());
                case CUSTOMER_REQUISITES_CHOICE -> manageRequisites(customer.getId());
                case CUSTOMER_BANK_ACCOUNTS_CHOICE -> manageBankAccounts(customer.getId());
                case CONTRACTS_CHOICE -> manageContracts(customer.getId());
                case WAYBILLS_CHOICE -> manageWayBills(customer.getId());
                case BILLS_CHOICE -> manageBills(customer.getId());
                //TODO changePrice
                case PRICE_CHOICE -> customerUI.displayPrice(customer.getPrice());
                case EXIT_CHOICE -> {
                    return;
                }
            }
        }
    }

    private void manageContracts(int customerId) {
        ContractUI contractUI = initialMenuUI.customer().contract();
        while (true) {
            dataListMenuUi.displayListMenu();
            switch (dataListMenuUi.getUserChoice()) {
                case CREATE_NEW_OBJECT_CHOICE ->
                        changeContract(new Contract(customerId, contractUI.getContractNumberFromUser()));
                case SELECT_OBJECT_CHOICE -> {
                    int userChoice = contractUI.getContractId(db.selectAll(customerId));
                    if (userChoice != NO_DATA) {
                        changeContract(db.select(userChoice));
                    }
                }
                case LIST_MENU_CANCEL_CHOICE -> {
                    return;
                }
            }
        }
    }

    private void changeContract(Contract contract) {
        ContractUI contractUI = initialMenuUI.customer().contract();
        Contract temp = contractUI.changeContract(contract);
        if (contract != temp && db.select(contract.getId()) != null) {
            db.update(temp);
        } else if (contract != temp) {
            db.insert(temp);
        }
    }

    private void manageWayBills(int customerId) {
        WayBillUI wayBillUI = initialMenuUI.customer().wayBill();
        while (true) {
            dataListMenuUi.displayListMenu();
            switch (dataListMenuUi.getUserChoice()) {
                case CREATE_NEW_OBJECT_CHOICE -> {
                    WayBill wayBill = new WayBill(customerId, wayBillUI.getWayBillNumberFromUser());
                    changeWayBill(wayBill);
                }
                case SELECT_OBJECT_CHOICE -> {

                    int userChoice = wayBillUI.getWayBillId(db.selectAll(customerId));
                    if (userChoice != NO_DATA) {
                        changeWayBill(db.select(userChoice));
                    }
                }
                case LIST_MENU_CANCEL_CHOICE -> {
                    return;
                }
            }
        }
    }

    private void changeWayBill(WayBill wayBill) {
        WayBillUI wayBillUI = initialMenuUI.customer().wayBill();
        while (true) {
            switch (wayBillUI.getAction(wayBill)) {
                case CHANGE_WAYBILL_DATA_CHOICE -> {
                    WayBill temp = wayBillUI.changeWayBill(wayBill);
                    if (wayBill != temp && db.select(wayBill.getId()) != null) {
                        db.update(temp);
                    } else if (wayBill != temp) {
                        db.insert(temp);
                    }
                }
                case DISPLAY_RECYCLABLE_UNITS_CHOICE -> wayBillUI.displayRecyclableUnits(wayBill.getWayBillData());
                case ADD_RECYCLABLE_UNIT_CHOICE -> addRecyclableUnit(wayBill);
                case DELETE_RECYCLABLE_UNIT_CHOICE -> deleteRecyclableUnit(wayBill);
                case EXIT_CHOICE -> {
                    return;
                }
            }
        }
    }

    private void addRecyclableUnit(WayBill wayBill) {
        WayBillUI wayBillUI = initialMenuUI.customer().wayBill();
        RecyclableUnitUI recyclableUnitUI = initialMenuUI.recyclableUnit();
        RecyclableUnit recyclableUnit;
        int recyclableUnitAmount;
        String recyclableUnitName;
        while (true) {
            recyclableUnitName = wayBillUI.getRecyclableUnitName();
            recyclableUnit = db.findByName(recyclableUnitName);
            if (recyclableUnit != null) {
                recyclableUnitAmount = wayBillUI.getRecyclableUnitAmount();
                wayBill.addRecyclableUnit(recyclableUnitName, recyclableUnitAmount);
                db.update(wayBill);

            } else {
                switch (wayBillUI.getActionWithRecyclableUnit()) {
                    case ADD_RECYCLABLE_UNIT_CHOICE -> {
                        RecyclableType type = RecyclableType.values()[recyclableUnitUI.getUnitTypeFromUser() - 1];
                        recyclableUnit = new RecyclableUnit(recyclableUnitName, type);
                        changeRecyclableUnit(recyclableUnit);
                        return;
                    }
                    case EXIT_CHOICE -> {
                        return;
                    }
                }
            }
        }
    }

    private void deleteRecyclableUnit(WayBill wayBill) {
        WayBillUI wayBillUI = initialMenuUI.customer().wayBill();
        while (true) {
            switch (wayBillUI.getActionWithRecyclableUnit()) {
                case DELETE_RECYCLABLE_UNIT_CHOICE -> {
                    wayBill.deleteRecyclableUnit(wayBillUI.getRecyclableUnitName());
                    db.update(wayBill);
                    return;
                }
                case EXIT_CHOICE -> {
                    return;
                }
            }
        }
    }

    private void manageBills(int customerId) {
        BillUI billUI = initialMenuUI.customer().bill();
        while (true) {
            dataListMenuUi.displayListMenu();
            switch (dataListMenuUi.getUserChoice()) {
                case CREATE_NEW_OBJECT_CHOICE -> {
                    Bill bill = new Bill(customerId, billUI.getBillNumberFromUser(), db.select(customerId).getPrice());
                    changeBill(bill);
                }
                case SELECT_OBJECT_CHOICE -> {
                    int userChoice = billUI.getBillId(db.selectAll(customerId));
                    if (userChoice != NO_DATA) {
                        changeBill(db.select(userChoice));
                    }
                }
                case LIST_MENU_CANCEL_CHOICE -> {
                    return;
                }
            }
        }
    }

    private void changeBill(Bill bill) {
        BillUI billUI = initialMenuUI.customer().bill();
        while (true) {
            switch (billUI.getAction(bill)) {
                case CHANGE_BILL_DATA_CHOICE -> {
                    Bill temp = billUI.changeBill(bill);
                    if (bill != temp && db.select(bill.getId()) != null) {
                        db.update(temp);
                    } else if (bill != temp) {
                        db.insert(temp);
                    }
                }
                case DISPLAY_BILL_DATA_CHOICE -> billUI.displayBillData(bill.getBillData());
                case ADD_WAYBILL_CHOICE -> {
                    addWayBill(bill);
                    db.update(bill);
                }
                case DELETE_WAYBILL_CHOICE -> deleteWayBill(bill);
                case DISPLAY_PRICE_CHOICE -> billUI.displayPrice(bill.getPrice());
                case EXIT_CHOICE -> {
                    return;
                }
            }
        }
    }

    private void addWayBill(Bill bill) {
        WayBillUI wayBillUI = initialMenuUI.customer().wayBill();
        List<WayBill> wayBills = db.findWayBillsWithoutBill(bill.getCUSTOMER_ID());
        int userChoice = wayBillUI.getWayBillId(wayBills);
        if (userChoice != NO_DATA) {
            WayBill wayBill = db.select(userChoice);
            wayBill.setBillNumber(bill.getNumber());
            Map<RecyclableType, Integer> billData = bill.getBillData();
            wayBill.getWayBillData().forEach((key, value) -> billData.put(db.findByName(key).getType(), value));
            bill.addWayBill(wayBill.getBillNumber(), billData);
        }
    }

    private void deleteWayBill(Bill bill) {
        BillUI billUI = initialMenuUI.customer().bill();
        List<String> wayBills = bill.getWayBills();
        int userChoice = billUI.getWayBillId(wayBills);
        if (userChoice != NO_DATA) {
            WayBill wayBill = db.select(userChoice);
            db.delete(userChoice);
            wayBill.getWayBillData().remove(wayBill.getBillNumber());
        }
    }

    private void manageRecyclableUnits() {
        RecyclableUnitUI recyclableUnitUI = initialMenuUI.recyclableUnit();
        while (true) {
            dataListMenuUi.displayListMenu();
            switch (dataListMenuUi.getUserChoice()) {
                case CREATE_NEW_OBJECT_CHOICE -> {
                    RecyclableType type = RecyclableType.values()[recyclableUnitUI.getUnitTypeFromUser() - 1];
                    changeRecyclableUnit(new RecyclableUnit(recyclableUnitUI.getUnitNameNameFromUser(), type));
                }
                case SELECT_OBJECT_CHOICE -> {
                    int userChoice = recyclableUnitUI.getRecyclableUnitId(db.selectAll());
                    if (userChoice != NO_DATA) {
                        changeRecyclableUnit(db.select(userChoice));
                    }
                }
                case LIST_MENU_CANCEL_CHOICE -> {
                    return;
                }
            }
        }
    }

    private void changeRecyclableUnit(RecyclableUnit recyclableUnit) {
        RecyclableUnitUI recyclableUnitUI = initialMenuUI.recyclableUnit();
        RecyclableUnit temp;
        switch (recyclableUnitUI.getAction(recyclableUnit)) {
            case CHANGE_RECYCLABLE_UNIT_DATA -> {
                temp = recyclableUnitUI.changeRecyclableUnit(recyclableUnit);
                if (recyclableUnit != temp && db.select(recyclableUnit.getId()) != null) {
                    db.update(temp);
                } else if (recyclableUnit != temp) {
                    db.insert(temp);
                }
            }
            case CHANGE_MATERIALS_AMOUNT -> {
                MaterialsUI materialsUI = recyclableUnitUI.materials();
                materialsUI.changeMaterialsList(db.select(recyclableUnit.getId()).getMaterials());
            }
            case EXIT_CHOICE -> {

            }
        }

    }

    private void updateOwnerData() {
        if (db.selectAll(owner.getID()).size() != 0) {
            owner.setRequisites(db.selectAll(owner.getID()).get(0));
        }
    }
}
