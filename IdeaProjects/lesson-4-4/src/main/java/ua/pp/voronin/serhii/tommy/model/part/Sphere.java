package ua.pp.voronin.serhii.tommy.model.part;

public final class Sphere extends Part {

    private int radiusInMM;

    public Sphere(int radiusInMM, double density) {
        super(density);
        this.radiusInMM = radiusInMM;
    }

    public int getRadius() {
        return radiusInMM;
    }

    public void setRadius(int radiusInMM) {
        this.radiusInMM = radiusInMM;
    }

    @Override
    public String toString() {
        return "сферична деталь {r=" + radiusInMM + '}';
    }
}
