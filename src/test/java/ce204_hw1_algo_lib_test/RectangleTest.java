package ce204_hw1_algo_lib_test;

import org.junit.Assert;
import org.junit.Test;

import ce204_hw1_algo_lib.Point;
import ce204_hw1_algo_lib.shapes.Rectangle;

public class RectangleTest {

    @Test
    public void testArea() {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setHeight(15);
        double expectedArea = 150;
        Assert.assertEquals(expectedArea, rectangle.getArea(), 0.01);
    }

    @Test
    public void testPerimeter() {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setHeight(15);
        double expectedPerimeter = 50;
        Assert.assertEquals(expectedPerimeter, rectangle.getPerimeterLength(), 0.01);
    }

    @Test
    public void testRotate() {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setHeight(15);
        rectangle.rotate(45);
        Point[] points = rectangle.getVertices();
        Point[] expectedPoints = { new Point(-9, -0.31), new Point(-3.75, 8.2), new Point(9, 0.31), new Point(3.75, -8.2) };
        for (int i = 0; i < points.length; i++) {
            Assert.assertEquals(expectedPoints[i].getX(), points[i].getX(), 0.01);
            Assert.assertEquals(expectedPoints[i].getY(), points[i].getY(), 0.01);
        }
    }

}