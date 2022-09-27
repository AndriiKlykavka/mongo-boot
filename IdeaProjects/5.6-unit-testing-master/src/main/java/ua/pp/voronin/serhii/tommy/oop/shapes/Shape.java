package ua.pp.voronin.serhii.tommy.oop.shapes;

public abstract class Shape {

    public abstract double getArea();

    public abstract String getName();

    @Override
    public String toString() {
        return "[Figure: " + getName() + " with area " + getArea() + "]";
    }
}
