package com.example.final_project_java.model.recyclableUnits;

import java.util.Map;
import java.util.TreeMap;

public class RecyclableUnit {
    private int id;
    private String name;
    private RecyclableType type = RecyclableType.LARGE;
    private int diagonal;
    private final Map<Material, Double> materials;

    public RecyclableUnit(String name) {
        this.name = name;
        materials = new TreeMap<>();
        for (int i = 0; i < Material.values().length; i++) {
            materials.put(Material.values()[i], 0.00);
        }
    }

    public RecyclableUnit(int id, String name, RecyclableType type, int diagonal, Map<Material, Double> materials) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.diagonal = diagonal;
        this.materials = materials;
    }

    public RecyclableUnit() {
        materials = new TreeMap<>();
        for (int i = 0; i < Material.values().length; i++) {
            materials.put(Material.values()[i], 0.00);
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

    public void setName(String name) {this.name = name;}

    public RecyclableType getType() {
        return type;
    }

    public void setType(RecyclableType type) {
        this.type = type;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        name = name + diagonal;
        this.diagonal = diagonal;
    }

    public Map<Material, Double> getMaterials() {
        return materials;
    }

    @Override
    public String toString() {
        return "Unique number: " + id +
                "\t Name: " + name +
                "\t Type: " + type +
                "\t Diagonal: " + diagonal;
    }
}
