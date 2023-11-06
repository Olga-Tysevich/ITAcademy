package com.example.final_project_java.database.impl;

import com.example.final_project_java.database.DB;
import com.example.final_project_java.model.customer.Customer;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerImpl extends DbSqliteImp implements DB<Customer> {
    DbSqliteImp dbSqliteImp = new DbSqliteImp();
    @Override
    public void insert(Customer customer) {
        SqlSessionFactory sqlSessionFactory = buildSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.insert("com.example.final_project_java.model.customer.Customer.insert", customer);
            session.commit();
            session.insert("com.example.final_project_java.model.customer.Customer.insertPrice", customer);
            session.commit();
        }
    }

    private void insertPrice(Customer customer){

    }

    @Override
    public void update(Customer customer) {
        SqlSessionFactory sqlSessionFactory = buildSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.update("com.example.final_project_java.model.customer.Customer.update", customer);
            if (!checkForPriceAvailability(customer.getPriceNumber())) {
                session.insert("com.example.final_project_java.model.customer.Customer.insertPrice", customer);
            }
            session.commit();
        }
        customer.getPrice().forEach((key, value) -> {
            try (Connection connection = createConnect()) {
                connection.prepareStatement("update prices set value = " + value + " where key = ' " + key + " ' AND customer_id = " + customer.getId()
                                + " AND price_number = " + customer.getPriceNumber())
                        .executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private boolean checkForPriceAvailability(int priceNumber){
        try (Connection connection = dbSqliteImp.createConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbSqliteImp.getDatabase().getProperty("selectPriceByNumber"));
            preparedStatement.setInt(1, priceNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public Customer select(int id) {
        SqlSessionFactory sqlSessionFactory = buildSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne("com.example.final_project_java.model.customer.Customer.selectById", id);
        }
    }

    @Override
    public List<Customer> selectAll(int ownerID) {
        SqlSessionFactory sqlSessionFactory = buildSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("com.example.final_project_java.model.customer.Customer.selectAll");
        }
    }

    @Override
    public Customer selectByName(String name) {
        SqlSessionFactory sqlSessionFactory = buildSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne("com.example.final_project_java.model.customer.Customer.selectByName", name);
        }
    }

    @Override
    public void delete(int id) {

    }
}