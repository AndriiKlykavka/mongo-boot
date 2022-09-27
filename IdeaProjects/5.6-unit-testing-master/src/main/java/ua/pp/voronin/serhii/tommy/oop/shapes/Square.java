package ua.pp.voronin.serhii.tommy.oop.shapes;

public class Square extends Rectangle {

    public Square(int side) {
        super(side, side);
    }

    @Override
    public void setSideA(Integer sideA) {
        super.setSideA(sideA);
        super.setSideB(sideA);
    }

    @Override
    public void setSideB(int sideB) {
        super.setSideA(sideB);
        super.setSideB(sideB);
    }

    @Override
    public String getName() {
        return "Square";
    }

}
