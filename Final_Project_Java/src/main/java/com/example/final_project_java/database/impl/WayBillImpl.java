package com.example.final_project_java.database.impl;

import com.example.final_project_java.database.WayBillDB;
import com.example.final_project_java.model.customer.WayBill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class WayBillImpl implements WayBillDB {
    DbSqliteImp dbSqliteImp = new DbSqliteImp();

    @Override
    public void insert(WayBill wayBill) {
        try (Connection connection = dbSqliteImp.createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("insertWayBill"));
            preparedStatement.setInt(1, wayBill.getCUSTOMER_ID());
            preparedStatement.setString(2, wayBill.getNumber());
            preparedStatement.setString(3, String.valueOf(wayBill.getDate()));
            preparedStatement.setInt(4, wayBill.getTotalPositions());
            preparedStatement.setString(5, wayBill.getNote());
            preparedStatement.setString(6, wayBill.getBillNumber());
            preparedStatement.executeUpdate();
            PreparedStatement preparedStatement2 = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("insertWayBillData"));
            for (String key : wayBill.getWayBillData().keySet()) {
                preparedStatement2.setInt(1, wayBill.getId());
                preparedStatement2.setString(2, key);
                preparedStatement2.setInt(3, wayBill.getWayBillData().get(key));
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    @Override
    public void update(WayBill wayBill) {
        try (Connection connection = dbSqliteImp.createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("updateWayBill"));
            preparedStatement.setInt(1, wayBill.getCUSTOMER_ID());
            preparedStatement.setString(2, wayBill.getNumber());
            preparedStatement.setString(3, String.valueOf(wayBill.getDate()));
            preparedStatement.setInt(4, wayBill.getTotalPositions());
            preparedStatement.setString(5, wayBill.getNote());
            preparedStatement.setString(6, wayBill.getBillNumber());
            preparedStatement.setInt(7, wayBill.getId());
            preparedStatement.executeUpdate();
            wayBill.getWayBillData().keySet().forEach(k -> {
                if (checkData(connection, wayBill.getId(), k)) {
                    updateData(connection, wayBill);
                } else {
                    insertData(connection, wayBill, k);
                }
            });
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    @Override
    public WayBill select(int id) {
        WayBill wayBill = null;
        try (Connection connection = dbSqliteImp.createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectWayBillByID"));
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                wayBill = createWayBill(resultSet);
                PreparedStatement preparedStatement2 = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectWayBillDataByID"));
                preparedStatement2.setInt(1, id);
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                while (resultSet2.next()) {
                    assert wayBill != null;
                    setWayBillData(wayBill, resultSet2);
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return wayBill;
    }

    @Override
    public WayBill selectByName(String name) {
        return null;
    }

    @Override
    public WayBill selectByNumber(String number) {
        WayBill wayBill = null;
        try (Connection connection = dbSqliteImp.createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectWayBillByNumber"));
            preparedStatement.setString(1, number);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                wayBill = createWayBill(resultSet);
                PreparedStatement preparedStatement2 = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectWayBillDataByID"));
                assert wayBill != null;
                preparedStatement2.setInt(1, wayBill.getId());
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                while (resultSet2.next()) {
                    setWayBillData(wayBill, resultSet2);
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return wayBill;
    }

    @Override
    public List<WayBill> selectWayBillsWithoutBill(int customerID) {
        List<WayBill> wayBills = new ArrayList<>();
        try (Connection connection = dbSqliteImp.createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectAllWayBillsWithoutBill"));
            preparedStatement.setInt(1, customerID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                WayBill wayBill = createWayBill(resultSet);
                PreparedStatement preparedStatement2 = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectWayBillDataByID"));
                assert wayBill != null;
                preparedStatement2.setInt(1, wayBill.getId());
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                while (resultSet2.next()) {
                    setWayBillData(wayBill, resultSet2);
                }
                wayBills.add(wayBill);
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return wayBills;
    }

    @Override
    public List<WayBill> selectAll(int customerID) {
        List<WayBill> wayBills = new ArrayList<>();
        try (Connection connection = dbSqliteImp.createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectAllWayBillsByCustomerID"));
            preparedStatement.setInt(1, customerID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                WayBill wayBill = createWayBill(resultSet);
                PreparedStatement preparedStatement2 = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectWayBillDataByID"));
                assert wayBill != null;
                preparedStatement2.setInt(1, wayBill.getId());
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                while (resultSet2.next()) {
                    setWayBillData(wayBill, resultSet2);
                }
                wayBills.add(wayBill);
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return wayBills;
    }

    @Override
    public void delete(int id) {

    }

    private WayBill createWayBill(ResultSet resultSet) {
        try {
            LocalDate date = null;
            try {
                date = LocalDate.parse(resultSet.getString("date"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            } catch (DateTimeParseException e) {
                System.out.println(e.getMessage());
            }
            WayBill wayBill = new WayBill(resultSet.getInt("id"), resultSet.getInt("customer_id"),
                    resultSet.getString("number"), date, new TreeMap<>(), resultSet.getInt("total_position"),
                    resultSet.getString("note"));
            wayBill.setBillNumber(resultSet.getString("bill_number"));
            return wayBill;
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }

    private void setWayBillData(WayBill wayBill, ResultSet resultSet) {
        try {
            wayBill.getWayBillData().put(resultSet.getString("recyclable_unit_name"), resultSet.getInt("amount"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private boolean checkData(Connection connection, int waybillId, String unitName) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectWayBillDataByWayBillID"));
            preparedStatement.setInt(1, waybillId);
            preparedStatement.setString(2, unitName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    private void insertData(Connection connection, WayBill wayBill, String key) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("insertWayBillData"));
            preparedStatement.setInt(1, wayBill.getId());
            preparedStatement.setString(2, key);
            preparedStatement.setInt(3, wayBill.getWayBillData().get(key));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateData(Connection connection, WayBill wayBill) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("updateWayBillData"));
            for (String key : wayBill.getWayBillData().keySet()) {
                preparedStatement.setString(1, key);
                preparedStatement.setInt(2, wayBill.getWayBillData().get(key));
                preparedStatement.setInt(3, wayBill.getId());
                preparedStatement.setString(4, key);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
