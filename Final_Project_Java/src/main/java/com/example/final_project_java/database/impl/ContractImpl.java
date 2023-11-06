package com.example.final_project_java.database.impl;

import com.example.final_project_java.database.DB;
import com.example.final_project_java.model.customer.Contract;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class ContractImpl implements DB<Contract> {
    DbSqliteImp dbSqliteImp = new DbSqliteImp();

    @Override
    public void insert(Contract contract) {
        try (Connection connection = dbSqliteImp.createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("insertContract"));
            preparedStatement.setInt(1, contract.getCUSTOMER_ID());
            preparedStatement.setString(2, contract.getNumber());
            preparedStatement.setString(3, String.valueOf(contract.getStartDate()));
            preparedStatement.setString(4, String.valueOf(contract.getEndDate()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    @Override
    public void update(Contract contract) {
        try (Connection connection = dbSqliteImp.createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("updateContract"));
            preparedStatement.setInt(1, contract.getCUSTOMER_ID());
            preparedStatement.setString(2, contract.getNumber());
            preparedStatement.setString(3, String.valueOf(contract.getStartDate()));
            preparedStatement.setString(4, String.valueOf(contract.getEndDate()));
            preparedStatement.setInt(5, contract.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    @Override
    public Contract select(int id) {
        try (Connection connection = dbSqliteImp.createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectContractByID"));
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return createContract(resultSet);
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }

    @Override
    public Contract selectByName(String name) {
        try (Connection connection = dbSqliteImp.createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectContractByNumber"));
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return createContract(resultSet);
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }


    @Override
    public List<Contract> selectAll(int customerID) {
        List<Contract> contracts = new ArrayList<>();
        try (Connection connection = dbSqliteImp.createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectAllContractsByCustomerID"));
            preparedStatement.setInt(1, customerID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Contract temp = createContract(resultSet);
                contracts.add(temp);
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return contracts;
    }

    @Override
    public void delete(int id) {
        try (Connection connection = dbSqliteImp.createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("deleteContract"));
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    private Contract createContract(ResultSet resultSet) {
        try {
            LocalDate startDate = null;
            LocalDate endDate = null;
            try {
                startDate = LocalDate.parse(resultSet.getString("start_date"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                endDate = LocalDate.parse(resultSet.getString("end_date"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            } catch (DateTimeParseException e) {
                System.out.println(e.getMessage());
            }
            return new Contract(resultSet.getInt("id"), resultSet.getInt("owner_id"),
                    resultSet.getString("number"), startDate, endDate);
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }
}
