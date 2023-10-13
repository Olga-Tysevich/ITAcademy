package project.database.dbcontroller;

import project.model.requisites.Requisites;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RequisitesSQLDB extends SQLDB {

    public void insertRequisites(Requisites requisites) {
        try (Connection connection = createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(database.getProperty("insertRequisites"));
            preparedStatement.setInt(1, requisites.getOWNER_ID());
            preparedStatement.setString(2, requisites.getNameForPrint());
            preparedStatement.setInt(3, requisites.getTaxpayerID());
            preparedStatement.setInt(4, requisites.getClassifierCode());
            preparedStatement.setString(5, requisites.getLegalAddress());
            preparedStatement.setString(6, requisites.getMailingAddress());
            preparedStatement.setString(7, requisites.getPhone());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void updateRequisites(Requisites requisites) {
        try (Connection connection = createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(database.getProperty("updateRequisites"));
            preparedStatement.setInt(1, requisites.getOWNER_ID());
            preparedStatement.setString(2, requisites.getNameForPrint());
            preparedStatement.setInt(3, requisites.getTaxpayerID());
            preparedStatement.setInt(4, requisites.getClassifierCode());
            preparedStatement.setString(5, requisites.getLegalAddress());
            preparedStatement.setString(6, requisites.getMailingAddress());
            preparedStatement.setString(7, requisites.getPhone());
            preparedStatement.setInt(8, requisites.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }


    public Requisites select(int id) {
        try (Connection connection = createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(database.getProperty("selectRequisites"));
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Requisites(resultSet.getInt("id"), resultSet.getInt("owner_id"), resultSet.getString("owner_name"),
                        resultSet.getInt("taxpayer_id"), resultSet.getInt("classifier_code"), resultSet.getString("legal_address"),
                        resultSet.getString("mailing_address"), resultSet.getString("phone"));
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }

    public List<Requisites> selectAll() {
        return null;
    }

    public List<Requisites> selectAll(int OwnerID) {
        return null;
    }

    public void delete(Requisites requisites) {

    }

    public int getID() {
        return 0;
    }
}
