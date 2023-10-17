package project.database;

import project.model.customer.WayBill;
import java.util.List;

public interface DB<E> {
    //Так как блин делать?! =)
    void insert(E entry);
    void update(E entry);
    E select(int id);
    E findByName(String name);
    E findByNumber(String number);
    List<WayBill> findWayBillsWithoutBill(int customerID);
    List<E> selectAll();
    List<E> selectAll(int customerID);
    void delete(E entry);
}
