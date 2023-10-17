package project.model.customer;

import project.model.recyclableUnits.RecyclableType;

import java.util.*;
import java.util.stream.IntStream;

public class Customer {
    private int id;
    private String name;
    private Map<RecyclableType, Double> price = new TreeMap<>();

    public Customer(String name) {
        this.name = name;
        IntStream.range(0, RecyclableType.values().length).forEach(i -> price.put(RecyclableType.values()[i], 0.00));
    }

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
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

    public Map<RecyclableType, Double> getPrice() {
        return price;
    }

    public void setPrice(Map<RecyclableType, Double> price) {
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