package project.model.recyclableUnits;

import java.util.SortedMap;
import java.util.TreeMap;

public class RecyclableUnit {
    private final int ID;
    private String name;
    private RecyclableType type;
    private int diagonal;
    private SortedMap<Material, Double> materials;

    public RecyclableUnit(int id) {
        ID = id;
        materials = new TreeMap<>();
        for (int i = 1; i < Material.values().length; i++) {
            materials.put(Material.getSecondaryMaterial(i), 0.00);
        }
    }

    public RecyclableUnit(int ID, String name, RecyclableType type, int diagonal, SortedMap<Material, Double> materials) {
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.diagonal = diagonal;
        this.materials = materials;
    }

    public RUWithSpareParts convertToRUWithSpareParts() {
        return new RUWithSpareParts(ID, name, type, diagonal, materials);
    }


    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public RecyclableType getType() {
        return type;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public SortedMap<Material, Double> getMaterials() {
        return materials;
    }

    @Override
    public String toString() {
        return "RecyclableUnit:\n" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", diagonal=" + diagonal +
                "\nSecondaryMaterials:{\n" + materials +
                '}';
    }
}
