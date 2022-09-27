package ua.pp.voronin.serhii.tommy.oop.shapes;

public class Rectangle extends Shape {

    private int sideA;
    private int sideB;

    public Rectangle(int sideA, int sideB) {
        if(sideA <= 0 || sideB <= 0) {
            throw new IllegalStateException();
        }
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public void setSideA(Integer sideA) {
        if (sideA == null || sideA <= 0) {
            throw new IllegalStateException("Side should be positive");
        }
        this.sideA = sideA;
    }

    public void setSideB(int sideB) {
        if (sideB <= 0) {
            throw new IllegalStateException("Side should be positive");
        }
        this.sideB = sideB;
    }

    @Override
    public double getArea() {
        return sideA * sideB;
    }

    @Override
    public String getName() {
        return "Rectangle";
    }
}
