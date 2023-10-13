package project.database;

import project.model.requisites.BankAccount;
import project.model.requisites.Requisites;

import java.util.List;

public interface DB {
    <E> void insert(E entry);

    <E> void update(E entry);

    Requisites selectRequisites(int id);
    BankAccount selectBankAccount(int id);
    List<Requisites> selectRequisitesList(int owner_id);
    List<BankAccount> selectBankAccounts(int owner_id);
    <E> void delete(E entry);
}
