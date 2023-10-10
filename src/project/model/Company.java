package project.model;

import project.model.requisites.BankAccount;
import project.model.requisites.Requisites;
import java.util.ArrayList;
import java.util.List;

public abstract class Company {
    private final int ID;
    private List<Requisites> requisitesList;
    private List<BankAccount> bankAccounts;

    public Company(int ID) {
        this.ID = ID;
        requisitesList = new ArrayList<>();
        bankAccounts =new ArrayList<>();
    }

    public void addRequisites(Requisites requisites){
        requisitesList.add(requisites);
    }

    public void removeRequisites(Requisites requisites){
        requisitesList.remove(requisites);
    }

    public void addBankAccount(BankAccount bankAccount){
        bankAccounts.add(bankAccount);
    }
    public void removeBankAccount(BankAccount bankAccount){
        bankAccounts.remove(bankAccount);
    }
    public void setRequisitesList(List<Requisites> requisitesList) {
        this.requisitesList = requisitesList;
    }

    public void setBankAccounts(List<BankAccount> ownerBankAccounts) {
        this.bankAccounts = ownerBankAccounts;
    }

    public int getID() {
        return ID;
    }

    public List<Requisites> getRequisitesList() {
        return requisitesList;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

}
