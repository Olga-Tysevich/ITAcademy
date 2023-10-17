package project.model.customer;

import project.model.recyclableUnits.RecyclableType;
import java.util.*;

public class Customer {
    private int id;
    private String name;
    private SortedMap<RecyclableType, Double> price = new TreeMap<>();

    public Customer(String name) {
        this.name = name;
        for (int i = 0; i < RecyclableType.values().length; i++) {
            price.put(RecyclableType.values()[i], 0.00);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SortedMap<RecyclableType, Double> getPrice() {
        return price;
    }

    public void setPrice(SortedMap<RecyclableType, Double> price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}