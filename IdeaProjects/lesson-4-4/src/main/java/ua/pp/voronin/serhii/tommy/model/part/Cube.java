package ua.pp.voronin.serhii.tommy.model.part;

public final class Cube extends Part {

    private int sideInMM;

    public Cube(int sideInMM, double density) {
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
        return "кубічна деталь {" + sideInMM + '*' + sideInMM + '*' + sideInMM + '}';
    }
}
