package com.example.final_project_java.model.customer;

import com.example.final_project_java.model.recyclableUnits.RecyclableType;

import java.util.*;

public class Customer {
    private int id;
    private String name;
    private int priceNumber = 1;
    private Map<RecyclableType, Double> price = new HashMap<>();

    public Customer(String name) {
        this.name = name;
        for (int i = 0; i < RecyclableType.values().length; i++) {
            price.put(RecyclableType.values()[i], 0.00);
        }
    }

    public Customer(int id, String name, int priceNumber, Map<RecyclableType, Double> price) {
        this.id = id;
        this.name = name;
        this.priceNumber = priceNumber;
        this.price = price;
    }

    public Customer(int id, String name, int priceNumber) {
        this(name);
        this.id = id;
        this.priceNumber = priceNumber;
    }

    public Customer(int id, String name, int priceNumber, String type, double price) {
        this(name);
        this.id = id;
        this.priceNumber = priceNumber;
    }

    public Map<RecyclableType, Double> getPrice() {
        return price;
    }

    public void setPrice(AbstractMap.SimpleImmutableEntry<String, Double> price) {
        this.price.put(RecyclableType.valueOf(price.getKey().replaceAll(" ", "")), price.getValue());
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

    public int getPriceNumber() {
        return priceNumber;
    }

    public void setPriceNumber(int priceNumber) {
        this.priceNumber = priceNumber;
    }

    @Override
    public String toString() {
        return "Unique number: " + id +
                "\t Name: " + name +
                "\t Current price number: " + priceNumber;
    }


}