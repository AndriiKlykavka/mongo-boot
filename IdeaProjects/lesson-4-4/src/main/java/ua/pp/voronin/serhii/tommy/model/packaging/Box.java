package ua.pp.voronin.serhii.tommy.model.packaging;

public class Box {

    private int sideInMM;

    public Box(int sideInMM) {
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
        return "ящик {" + sideInMM + '*' + sideInMM + '*' + sideInMM + '}';
    }
}
