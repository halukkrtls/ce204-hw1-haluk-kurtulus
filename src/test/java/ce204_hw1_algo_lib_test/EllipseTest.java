package ce204_hw1_algo_lib_test;

import org.junit.Assert;
import org.junit.Test;

import ce204_hw1_algo_lib.shapes.Ellipse;

public class EllipseTest {

    @Test
    public void testArea() {
        Ellipse ellipse = new Ellipse();
        ellipse.setSemiMajorAxis(2);
        ellipse.setSemiMinorAxis(1);
        Assert.assertEquals(Math.PI * 2 * 1, ellipse.getArea(), 0.01);
    }

    @Test
    public void testPerimeter() {
        Ellipse ellipse = new Ellipse();
        ellipse.setSemiMajorAxis(2);
        ellipse.setSemiMinorAxis(1);
        double expectedPerimeter = 2 * Math.PI * Math.sqrt((Math.pow(2, 2) + Math.pow(1, 2)) / 2);
        Assert.assertEquals(expectedPerimeter, ellipse.getPerimeterLength(), 0.01);
    }

    @Test
    public void testRotate() {
        Ellipse ellipse = new Ellipse();
        ellipse.setSemiMajorAxis(2);
        ellipse.setSemiMinorAxis(1);
        ellipse.rotate(45);
        Assert.assertEquals(45, ellipse.getOrientation(), 0.01);    }
}
