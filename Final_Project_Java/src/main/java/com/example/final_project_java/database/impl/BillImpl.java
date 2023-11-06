package com.example.final_project_java.database.impl;

import com.example.final_project_java.database.BillDB;
import com.example.final_project_java.model.customer.Bill;
import com.example.final_project_java.model.recyclableUnits.RecyclableType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BillImpl implements BillDB {
    DbSqliteImp dbSqliteImp = new DbSqliteImp();
    @Override
    public void insert(Bill bill) {
        int id = 0;
        try (Connection connection = dbSqliteImp.createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("insertBill"));
            preparedStatement.setInt(1, bill.getCUSTOMER_ID());
            preparedStatement.setString(2, bill.getNumber());
            preparedStatement.setString(3, String.valueOf(bill.getDate()));
            preparedStatement.setInt(4, bill.getOwnerBankAccountId());
            preparedStatement.setInt(5, bill.getCustomerRequisitesId());
            preparedStatement.setInt(6, bill.getCustomerBankAccountId());
            preparedStatement.setInt(7, bill.getPRICE_NUMBER());
            preparedStatement.setDouble(8, bill.getSum());
            preparedStatement.executeUpdate();
            PreparedStatement preparedStatement2 = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectBillId"));
            ResultSet resultSet2 = preparedStatement2.executeQuery();
            while (resultSet2.next()) {
                id = resultSet2.getInt("MAX") == 0 ? 1 : resultSet2.getInt("MAX");
            }
            final int billId = id;
            bill.getWayBills().forEach(s -> insertData(connection, billId, s));
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }


    @Override
    public void update(Bill bill) {
        try (Connection connection = dbSqliteImp.createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("updateBill"));
            preparedStatement.setString(1, bill.getNumber());
            preparedStatement.setString(2, String.valueOf(bill.getDate()));
            preparedStatement.setInt(3, bill.getOwnerBankAccountId());
            preparedStatement.setInt(4, bill.getCustomerRequisitesId());
            preparedStatement.setInt(5, bill.getCustomerBankAccountId());
            preparedStatement.setInt(6, bill.getPRICE_NUMBER());
            preparedStatement.setDouble(7, bill.getSum());
            preparedStatement.setInt(8, bill.getId());
            preparedStatement.executeUpdate();
            bill.getWayBills().forEach(s -> {
                if (!checkData(connection, bill.getId(), s)) {
                    insertData(connection, bill.getId(), s);
                }
            });
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    @Override
    public Bill select(int id) {
        Bill bill = null;
        try (Connection connection = dbSqliteImp.createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectBillByID"));
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bill = createBill(resultSet);
                PreparedStatement preparedStatement2 = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectBillData"));
                assert bill != null;
                preparedStatement2.setInt(1, bill.getId());
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                while (resultSet2.next()) {
                    setBillData(bill, resultSet2);
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return bill;
    }
    @Override
    public Bill selectByNumber(String name) {
        Bill bill = null;
        try (Connection connection = dbSqliteImp.createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectBillByNumber"));
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bill = createBill(resultSet);
                PreparedStatement preparedStatement2 = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectBillData"));
                assert bill != null;
                preparedStatement2.setInt(1, bill.getId());
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                while (resultSet2.next()) {
                    setBillData(bill, resultSet2);
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return bill;
    }

    @Override
    public Map<RecyclableType, Double> selectPrice(int priceNumber) {
        Map<RecyclableType, Double> price = new TreeMap<>();
        try (Connection connection = dbSqliteImp.createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectPriceByNumber"));
            preparedStatement.setInt(1, priceNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                price.put(RecyclableType.valueOf(resultSet.getString("key").replaceAll(" ", "")), resultSet.getDouble("value"));
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return price;
    }

    @Override
    public Bill selectByName(String name) {
        return null;
    }

    @Override
    public List<Bill> selectAll(int customerID) {
        List<Bill> bills = new ArrayList<>();
        try (Connection connection = dbSqliteImp.createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectAllBillByCustomerID"));
            preparedStatement.setInt(1, customerID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Bill bill = createBill(resultSet);
                PreparedStatement preparedStatement2 = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectBillData"));
                assert bill != null;
                preparedStatement2.setInt(1, bill.getId());
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                while (resultSet2.next()) {
                    setBillData(bill, resultSet2);
                }
                bills.add(bill);
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return bills;
    }

    @Override
    public void delete(int id) {

    }


    private boolean checkData(Connection connection, int billId, String wayBillNumber) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("checkBillData"));
            preparedStatement.setInt(1, billId);
            preparedStatement.setString(2, wayBillNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    private void insertData(Connection connection, int billId, String wayBillNumber) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("insertBillData"));
            preparedStatement.setInt(1, billId);
            preparedStatement.setString(2, wayBillNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setBillData(Bill bill, ResultSet resultSet) {
        try {
            bill.getWayBills().add(resultSet.getString("waybill_number"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Bill createBill(ResultSet resultSet) {
        try {
            LocalDate date = null;
            try {
                date = LocalDate.parse(resultSet.getString("date"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            } catch (DateTimeParseException e) {
                System.out.println(e.getMessage());
            }
            return new Bill(resultSet.getInt("id"), resultSet.getInt("customer_id"), resultSet.getString("number"),
                    date, resultSet.getInt("owner_bank_account_id"), resultSet.getInt("customer_requisites_id"),
                    resultSet.getInt("customer_bank_account_id"), new ArrayList<>(), resultSet.getInt("price_id"),
                    resultSet.getDouble("sum"));
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }
}
