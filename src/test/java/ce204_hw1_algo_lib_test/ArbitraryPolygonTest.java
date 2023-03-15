package ce204_hw1_algo_lib_test;

import org.junit.Assert;
import org.junit.Test;

import ce204_hw1_algo_lib.shapes.ArbitraryPolygon;

public class ArbitraryPolygonTest {

    @Test
    public void testArea() {
        ArbitraryPolygon arbitraryPolygon = new ArbitraryPolygon();
        arbitraryPolygon.addPoint(0, 0);
        arbitraryPolygon.addPoint(0, 2);
        arbitraryPolygon.addPoint(2, 2);
        arbitraryPolygon.addPoint(2, 0);

        double expectedArea = 4;
        Assert.assertEquals(expectedArea, arbitraryPolygon.getArea(), 0.01);
    }

    @Test
    public void testPerimeter() {
        ArbitraryPolygon arbitraryPolygon = new ArbitraryPolygon();
        arbitraryPolygon.addPoint(0, 0);
        arbitraryPolygon.addPoint(0, 2);
        arbitraryPolygon.addPoint(2, 2);
        arbitraryPolygon.addPoint(2, 0);

        double expectedPerimeter = 8;
        Assert.assertEquals(expectedPerimeter, arbitraryPolygon.getPerimeterLength(), 0.01);
    }
	
}