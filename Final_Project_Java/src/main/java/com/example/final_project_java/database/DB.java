package com.example.final_project_java.database;

import java.util.List;

public interface DB<E> {
    void insert(E entry);
    void update(E entry);
    E select(int id);
    List<E> selectAll(int customerID);
    E selectByName(String name);
    void delete(int id);
}
