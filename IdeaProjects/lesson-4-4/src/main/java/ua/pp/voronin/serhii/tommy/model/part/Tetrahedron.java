package ua.pp.voronin.serhii.tommy.model.part;

public final class Tetrahedron extends Part {

    private int sideInMM;

    public Tetrahedron(int sideInMM, double density) {
        super(density);
        this.sideInMM = sideInMM;
    }

    public int getSide() {
        return sideInMM;
    }

    public void setSide(int sideInMM) {
        this.sideInMM = sideInMM;
    }

    @Override
    public String toString() {
        return "пірамідальна деталь {a=" + sideInMM + '}';
    }
}
