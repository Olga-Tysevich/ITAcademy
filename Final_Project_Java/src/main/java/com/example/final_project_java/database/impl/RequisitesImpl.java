package com.example.final_project_java.database.impl;

import com.example.final_project_java.database.DB;
import com.example.final_project_java.model.requisites.Requisites;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class RequisitesImpl extends DbSqliteImp implements DB<Requisites> {

    @Override
    public void insert(Requisites requisites) {
        SqlSessionFactory sqlSessionFactory = buildSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.insert("com.example.final_project_java.model.requisites.Requisites.insert", requisites);
            session.commit();
        }
    }

    @Override
    public void update(Requisites requisites) {
        SqlSessionFactory sqlSessionFactory = buildSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.update("com.example.final_project_java.model.requisites.Requisites.update", requisites);
            session.commit();
        }
    }

    @Override
    public Requisites select(int id) {
        SqlSessionFactory sqlSessionFactory = buildSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne("com.example.final_project_java.model.requisites.Requisites.selectById", id);
        }
    }

    @Override
    public List<Requisites> selectAll(int customerID) {
        SqlSessionFactory sqlSessionFactory = buildSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("com.example.final_project_java.model.requisites.Requisites.selectAllByOwnerID", customerID);
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Requisites selectByName(String name) {
        SqlSessionFactory sqlSessionFactory = buildSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne("com.example.final_project_java.model.requisites.Requisites.selectByOwnerName", name);
        }
    }
}