package project.model.recyclableUnits;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class RUWithSpareParts extends RecyclableUnit {
    private Map<String, Double> spareParts;

    public RUWithSpareParts(int ID, String name, RecyclableType type, int diagonal, SortedMap<Material, Double> secondaryMaterials) {
        super(ID, name, type, diagonal, secondaryMaterials);
        spareParts = new TreeMap<>();
    }

    private void setSpareParts(String sparePartName, double sparePartPrice) {
        spareParts = spareParts == null ? new TreeMap<>() : spareParts;
        spareParts.put(sparePartName, sparePartPrice);
    }

    public void deleteSparePart(String sparePartName) {
        spareParts.remove(sparePartName);
    }

    public RecyclableUnit convertToRecyclableUnit() {
        return new RecyclableUnit(super.getID(), super.getName(), super.getType(), super.getDiagonal(), super.getMaterials());
    }

    public Map<String, Double> getSpareParts() {
        return spareParts == null ? new TreeMap<>() : spareParts;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nSpareParts:{\n" + spareParts +
                "\n}";
    }
}
