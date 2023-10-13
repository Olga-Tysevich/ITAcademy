package project.database.dbcontroller;

import project.database.DB;
import project.model.requisites.BankAccount;
import project.model.requisites.Requisites;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class SQLDB implements DB {
    Properties database;

    public SQLDB() {
        this.database = new Properties();
        try {
            database.load(Files.newInputStream(Paths.get("src\\project\\database\\database.properties")));
        } catch (IOException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public Connection createConnect() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:src\\project\\database\\company.db");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void insert(Object entry) {
        if (entry instanceof Requisites) {
            RequisitesSQLDB requisitesSQLDB = new RequisitesSQLDB();
            requisitesSQLDB.insertRequisites((Requisites) entry);
        }
    }

    @Override
    public void update(Object entry) {
        if (entry instanceof Requisites) {
            RequisitesSQLDB requisitesSQLDB = new RequisitesSQLDB();
            requisitesSQLDB.updateRequisites((Requisites) entry);
        }
    }

    @Override
    public Requisites selectRequisites(int id) {
        RequisitesSQLDB requisitesDB = new RequisitesSQLDB();
        return requisitesDB.select(id);
    }

    @Override
    public BankAccount selectBankAccount(int id) {
        return null;
    }

    @Override
    public List<Requisites> selectRequisitesList(int owner_id) {
        return null;
    }

    @Override
    public List<BankAccount> selectBankAccounts(int owner_id) {
        return null;
    }

    @Override
    public <E> void delete(E entry) {

    }
}
