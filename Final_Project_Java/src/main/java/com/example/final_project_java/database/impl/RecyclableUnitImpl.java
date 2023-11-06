package com.example.final_project_java.database.impl;

import com.example.final_project_java.database.DB;
import com.example.final_project_java.model.recyclableUnits.Material;
import com.example.final_project_java.model.recyclableUnits.RecyclableType;
import com.example.final_project_java.model.recyclableUnits.RecyclableUnit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RecyclableUnitImpl implements DB<RecyclableUnit> {
    DbSqliteImp dbSqliteImp = new DbSqliteImp();

    @Override
    public void insert(RecyclableUnit recyclableUnit) {
        int id = 0;
        try (Connection connection = dbSqliteImp.createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("insertRecyclableUnit"));
            preparedStatement.setString(1, recyclableUnit.getName());
            preparedStatement.setString(2, String.valueOf(recyclableUnit.getType()));
            preparedStatement.setInt(3, recyclableUnit.getDiagonal());
            preparedStatement.executeUpdate();
            PreparedStatement preparedStatement2 = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectId"));
            ResultSet resultSet2 = preparedStatement2.executeQuery();
            while (resultSet2.next()) {
                id = resultSet2.getInt("MAX") == 0 ? 1 : resultSet2.getInt("MAX");
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        insertUnitData(recyclableUnit, id);
    }

    private void insertUnitData(RecyclableUnit recyclableUnit, int id) {
        try (Connection connection = dbSqliteImp.createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("insertRecyclableUnitData"));
            Map<Material, Double> materials = recyclableUnit.getMaterials();
            for (Material material : materials.keySet()) {
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, String.valueOf(material));
                preparedStatement.setDouble(3, materials.get(material));
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    @Override
    public void update(RecyclableUnit unit) {
        try (Connection connection = dbSqliteImp.createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("updateRecyclableUnit"));
            preparedStatement.setString(1, unit.getName());
            preparedStatement.setString(2, String.valueOf(unit.getType()));
            preparedStatement.setInt(3, unit.getDiagonal());
            preparedStatement.setInt(4, unit.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        updateUnitData(unit);
    }

    private void updateUnitData(RecyclableUnit unit) {
        try (Connection connection = dbSqliteImp.createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("updateRecyclableUnitData"));
            Map<Material, Double> materials = unit.getMaterials();
            for (Material material : materials.keySet()) {
                preparedStatement.setDouble(1,  materials.get(material));
                preparedStatement.setInt(2, unit.getId());
                preparedStatement.setString(3, String.valueOf(material));
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    @Override
    public RecyclableUnit select(int id) {
        RecyclableUnit recyclableUnit = null;
        try (Connection connection = dbSqliteImp.createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectRecyclableUnitByID"));
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                recyclableUnit = createRecyclableUnit(resultSet);
                PreparedStatement preparedStatement2 = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectRecyclableUnitDataByID"));
                preparedStatement.setInt(1, id);
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                while (resultSet2.next()) {
                    assert recyclableUnit != null;
                    setRecyclableUnitData(recyclableUnit, resultSet2);
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return recyclableUnit;
    }

    @Override
    public RecyclableUnit selectByName(String name) {
        RecyclableUnit recyclableUnit = null;
        try (Connection connection = dbSqliteImp.createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectRecyclableUnitByName"));
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                recyclableUnit = createRecyclableUnit(resultSet);
                PreparedStatement preparedStatement2 = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectRecyclableUnitDataByID"));
                assert recyclableUnit != null;
                preparedStatement.setInt(1, recyclableUnit.getId());
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                while (resultSet2.next()) {
                    setRecyclableUnitData(recyclableUnit, resultSet2);
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return recyclableUnit;
    }

    @Override
    public List<RecyclableUnit> selectAll(int customerID) {
        List<RecyclableUnit> recyclableUnits = new ArrayList<>();
        try (Connection connection = dbSqliteImp.createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectAllRecyclableUnits"));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                RecyclableUnit recyclableUnit = createRecyclableUnit(resultSet);
                PreparedStatement preparedStatement2 = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectRecyclableUnitDataByID"));
                assert recyclableUnit != null;
                preparedStatement2.setInt(1, recyclableUnit.getId());
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                while (resultSet2.next()) {
                    setRecyclableUnitData(recyclableUnit, resultSet2);
                }
                recyclableUnits.add(recyclableUnit);
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return recyclableUnits;
    }

    private RecyclableUnit createRecyclableUnit(ResultSet resultSet) {
        try {
            RecyclableType type = RecyclableType.valueOf(resultSet.getString("TN"));
            return new RecyclableUnit(resultSet.getInt("id"), resultSet.getString("RUN"),
                    type, resultSet.getInt("diagonal"), new TreeMap<>());
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }

    private void setRecyclableUnitData(RecyclableUnit recyclableUnit, ResultSet resultSet) {
        try {
            recyclableUnit.getMaterials().put(Material.valueOf(resultSet.getString("MN")), resultSet.getDouble("amount"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {

    }
}

