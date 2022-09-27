package ua.pp.voronin.serhii.tommy.oop.shapes;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CircleTest {

    private Circle testCircle = new Circle(3);

    @Test(expected = IllegalStateException.class)
    public void failToCreateCircleWithNegativeRadius() {
        new Circle(-3);
    }

    @Test(expected = IllegalStateException.class)
    public void failToCreateCircleWithZeroRadius() {
        new Circle(0);
    }

    @Test
    public void checkAreaCalculation() {
        assertEquals(Math.PI * 9, testCircle.getArea(), 0.0);
    }

    @Test
    public void setRadiusProperly() {
        testCircle.setRadius(4);
        assertEquals(Math.PI * 16, testCircle.getArea(), 0.0);
    }

    @Test(expected = IllegalStateException.class)
    public void setRadiusToNegativeThrowsException() {
        testCircle.setRadius(-3);
    }

    @Test(expected = IllegalStateException.class)
    public void setRadiusToZeroThrowsException() {
        testCircle.setRadius(-3);
    }

    @Test
    public void testNameReturnsProperName(){
        assertEquals("Circle", testCircle.getName());
    }
}
