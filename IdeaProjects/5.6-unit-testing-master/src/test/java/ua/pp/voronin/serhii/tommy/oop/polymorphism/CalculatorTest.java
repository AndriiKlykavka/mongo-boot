package ua.pp.voronin.serhii.tommy.oop.polymorphism;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import ua.pp.voronin.serhii.tommy.oop.shapes.Shape;
import ua.pp.voronin.serhii.tommy.oop.shapes.Square;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {

    private static final double SAMPLE_AREA = 15;
    @Mock
    private Shape mockShape;

    @Test
    public void verifySimpleShapeAreaIsNotChanged() {
        when(mockShape.getArea()).thenReturn(SAMPLE_AREA);
        double area = Calculator.calculateArea(mockShape);
        assertEquals(SAMPLE_AREA, area, 0.0);
    }

    @Test(expected = IllegalStateException.class)
    public void verifyNullShapeThrowsIllegalStateException() {
            Calculator.calculateArea(null);
    }
}
