package project.ui;


import project.model.recyclableUnits.RecyclableUnit;
import java.util.List;

public interface RecyclableUnitUI {
    int getAction(RecyclableUnit recyclableUnit);
    RecyclableUnit changeRecyclableUnit(RecyclableUnit recyclableUnit);
    String getUnitNameNameFromUser();
    int getUnitTypeFromUser();
    int getRecyclableUnitId(List<RecyclableUnit> recyclableUnits);
    MaterialsUI materials();
}
