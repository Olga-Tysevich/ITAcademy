package project.model.recyclableUnits;

public enum RecyclableType {
    SMALL,
    MID,
    LARGE,
    ACCESSORY,
    TV;

    public static RecyclableType getRecyclableType(int position) {
        return RecyclableType.values()[position -1];
    }
}
