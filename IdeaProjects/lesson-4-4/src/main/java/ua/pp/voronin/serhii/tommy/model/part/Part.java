package ua.pp.voronin.serhii.tommy.model.part;

sealed public abstract class Part permits Cube, Sphere, Tetrahedron {

    private double densityInGramsPerCubeM;
    private final int kilogramsPerMaterialUnit = 30;

    public Part(double densityInGramsPerCubeM) {
        this.densityInGramsPerCubeM = densityInGramsPerCubeM;
    }

    public double getDensity() {
        return densityInGramsPerCubeM;
    }

    public void setDensity(double densityInGramsPerCubeM) {
        this.densityInGramsPerCubeM = densityInGramsPerCubeM;
    }

    public double getProtectiveLayerThickness(double weightInGrams) {
        double weightInKilograms = weightInGrams / 1000;
        return weightInKilograms / kilogramsPerMaterialUnit;
    }
}
