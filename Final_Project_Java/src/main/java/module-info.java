module com.example.final_project_java {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mybatis;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    requires org.slf4j;
    requires org.apache.poi.ooxml;

    opens com.example.final_project_java to org.mybatis, javafx.fxml, org.slf4j, org.apache.poi.ooxml;
    opens com.example.final_project_java.model.requisites to org.mybatis, javafx.fxml, org.slf4j, org.apache.poi.ooxml;
    exports com.example.final_project_java;

    exports com.example.final_project_java.controllers;
    opens com.example.final_project_java.controllers to org.mybatis, javafx.fxml, org.slf4j, org.apache.poi.ooxml;

    exports com.example.final_project_java.model.customer;
    opens com.example.final_project_java.model.customer to org.mybatis, javafx.fxml, org.slf4j, org.apache.poi.ooxml;

    exports com.example.final_project_java.model.requisites;

    exports com.example.final_project_java.model.recyclableUnits;
    opens com.example.final_project_java.model.recyclableUnits to org.mybatis, javafx.fxml, org.slf4j, org.apache.poi.ooxml;

    exports com.example.final_project_java.database.impl;
    opens com.example.final_project_java.database.impl to org.mybatis, javafx.fxml, org.slf4j, org.apache.poi.ooxml;

    exports com.example.final_project_java.database;
    opens com.example.final_project_java.database to org.mybatis, javafx.fxml, org.slf4j, org.apache.poi.ooxml;

    exports com.example.final_project_java.utils;
    opens com.example.final_project_java.utils to org.mybatis, javafx.fxml, org.slf4j, org.apache.poi.ooxml;
}