package project.model.recyclableUnits;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class RecyclableUnit {
    private int id;
    private String name;
    private RecyclableType type;
    private int diagonal;
    private Map<Material, Double> materials;

    public RecyclableUnit(String name, RecyclableType type) {
        this.name = name;
        this.type = type;
        materials = new TreeMap<>();
        IntStream.range(0, Material.values().length).forEach(i -> materials.put(Material.values()[i], 0.00));
    }

    public RecyclableUnit(int id, String name, RecyclableType type, int diagonal, Map<Material, Double> materials) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.diagonal = diagonal;
        this.materials = materials;
    }

    public void changeMaterials(Material name, double amount) {
        materials.put(name, amount);
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
        this.diagonal = diagonal;
    }

    public Map<Material, Double> getMaterials() {
        return materials;
    }

    public void setMaterials(SortedMap<Material, Double> materials) {
        this.materials = materials;
    }

    @Override
    public String toString() {
        return "RecyclableUnit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", diagonal=" + diagonal +
                '}';
    }
}
