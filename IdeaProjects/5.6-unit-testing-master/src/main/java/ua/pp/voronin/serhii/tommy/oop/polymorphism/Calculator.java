package ua.pp.voronin.serhii.tommy.oop.polymorphism;

import ua.pp.voronin.serhii.tommy.oop.shapes.Shape;
import ua.pp.voronin.serhii.tommy.oop.shapes.Square;

public class Calculator {

    public static double calculateArea(Shape shape) {
        if(shape == null){
            throw new IllegalStateException("Shape cannot be null");
        }
        double area = shape.getArea();
        System.out.println("Area of an object " + shape + " equals " + area);
        return area;
    }
}
