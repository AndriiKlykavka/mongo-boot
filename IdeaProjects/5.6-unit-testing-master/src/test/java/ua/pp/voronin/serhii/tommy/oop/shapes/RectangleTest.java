package ua.pp.voronin.serhii.tommy.oop.shapes;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {

    private Rectangle testRectangle = new Rectangle(2,4);

    @Test
    public void setSideBWorksProperly() {
        testRectangle.setSideB(5);
        assertEquals(10, testRectangle.getArea(), 0.0);
    }

    @Test(expected = IllegalStateException.class)
    public void setSideBToNegativeThrowsException() {
        testRectangle.setSideB(-4);
    }

    @Test(expected = IllegalStateException.class)
    public void setSideBToZeroThrowsException() {
        testRectangle.setSideB(0);
    }

    @Test
    public void checkNameReturnsProperName(){
        assertEquals("Rectangle", testRectangle.getName());
    }
}
