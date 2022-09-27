package ua.pp.voronin.serhii.tommy.oop.shapes;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SquareTest {

    private Square testSquare = new Square(5);

    @Test(expected = IllegalStateException.class)
    public void failToCreateSquareWithNegativeSide() {
        new Square(-4);
    }

    @Test(expected = IllegalStateException.class)
    public void failToCreateSquareWithZeroSide() {
        new Square(0);
    }

    @Test
    public void checkAreaCalculation() {
        assertEquals(25, testSquare.getArea(), 0.0);
    }

    @Test
    public void setSideAWorksProperly() {
        testSquare.setSideA(7);
        assertEquals(49, testSquare.getArea(),0.0);
    }

    @Test(expected = IllegalStateException.class)
    public void setSideAToNegativeThrowsException() {
        testSquare.setSideA(-4);
    }

    @Test(expected = IllegalStateException.class)
    public void setSideAToZeroThrowsException() {
        testSquare.setSideA(0);
    }

    @Test
    public void setSideBWorksProperly() {
        testSquare.setSideB(7);
        assertEquals(49, testSquare.getArea(),0.0);
    }

    @Test(expected = IllegalStateException.class)
    public void setSideBToNegativeThrowsException() {
        testSquare.setSideB(-4);
    }

    @Test(expected = IllegalStateException.class)
    public void setSideBToZeroThrowsException() {
        testSquare.setSideB(0);
    }

    @Test
    public void testNameReturnsProperName(){
        assertEquals("Square", testSquare.getName());
    }
}
