package com.example.final_project_java.database.impl;

import com.example.final_project_java.database.DB;
import com.example.final_project_java.model.requisites.BankAccount;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BankAccountImpl extends DbSqliteImp implements DB<BankAccount> {

    @Override
    public void insert(BankAccount account) {
        SqlSessionFactory sqlSessionFactory = buildSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.insert("com.example.final_project_java.model.requisites.BankAccount.insert", account);
            session.commit();
        }
    }

    @Override
    public void update(BankAccount account) {
        SqlSessionFactory sqlSessionFactory = buildSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.update("com.example.final_project_java.model.requisites.BankAccount.update", account);
            session.commit();
        }
    }

    @Override
    public BankAccount select(int id) {
        SqlSessionFactory sqlSessionFactory = buildSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne("com.example.final_project_java.model.requisites.BankAccount.selectById", id);
        }
    }

    @Override
    public List<BankAccount> selectAll(int customerID) {
        SqlSessionFactory sqlSessionFactory = buildSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("com.example.final_project_java.model.requisites.BankAccount.selectAllByOwnerID", customerID);
        }
    }

    @Override
    public BankAccount selectByName(String name) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
