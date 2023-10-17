package project.ui;

import project.model.recyclableUnits.Material;

import java.util.Map;

public interface MaterialsUI {
    void changeMaterialsList(Map<Material, Double> materials);
}
