package project.database;

import project.DataType;
import java.util.List;

public interface DB {
    <E> void insert(E entry);
    <E> void update(E entry);
    <E> E select(DataType dbName, int ID);
    <E> List<E> selectAll(DataType dbName);
    <E> List<E> selectAll(DataType dbName, int customerID);
    <E> void delete(E entry);
    int getID(DataType dataType);
}
