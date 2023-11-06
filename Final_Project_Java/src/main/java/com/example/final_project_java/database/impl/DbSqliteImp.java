package com.example.final_project_java.database.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbSqliteImp {

    Properties database;


    public DbSqliteImp() {
        this.database = new Properties();
        try {
            database.load(Files.newInputStream(Paths.get("Final_Project_Java/src/main/resources/com/example/final_project_java/sqlQueries.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection createConnect() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:Final_Project_Java/src/main/java/com/example/final_project_java/databasefile/company.db");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Properties getDatabase() {
        return database;
    }


    public SqlSessionFactory buildSessionFactory() {
        InputStream inputStream;
        try {
            String resource = "MyBatisConfig.xml";
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
}