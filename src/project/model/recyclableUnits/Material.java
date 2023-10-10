package project.model.recyclableUnits;

public enum Material {
    CARDBOARD,
    GLASS,
    PLASTIC,
    BLACK_METAL,
    ALUMINUM,
    COPPER,
    LEAD,
    BRASS,
    BOARD;

    public static Material getSecondaryMaterial(int position) {
        return Material.values()[position - 1];
    }
}
