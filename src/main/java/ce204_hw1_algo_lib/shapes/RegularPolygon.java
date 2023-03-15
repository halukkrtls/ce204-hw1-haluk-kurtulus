package ce204_hw1_algo_lib.shapes;

import ce204_hw1_algo_lib.Point;
import ce204_hw1_algo_lib.shapes.abstracts.SimplePolygon;

/**
 * RegularPolygon class
 * @author Haluk
 * @see SimplePolygon
 */
public class RegularPolygon extends SimplePolygon {

    /**
     * Number of points of the polygon
     */
    protected int numPoints;

    /**
     * to an an an a based based based an a based an a
     * @see <a href="https://www.omnicalculator.com/math/regular-polygon#regular-polygon-formulas-sides-area-perimeter-angles">https://www.omnicalculator.com/math/regular-polygon#regular-polygon-formulas-sides-area-perimeter-angles</a>
     */
    protected double radius;

    /**
     * Constructor
     * 0 is entered as the number of points.
     * Sets the radius to 0

     * Sets the orientation to 0
     */
    public RegularPolygon() {
        this(0, 1);
    }

    /**
     * Constructor
     * sets numPoints as the number of points.
     * the radius is changed to radius
 
     * Sets the orientation to 0
     * @param numPoints
     * @param radius
     */
    public RegularPolygon(int numPoints, double radius) {
        super();
        this.numPoints = numPoints;
        this.radius = radius;
    }


    /**
     * set the polygon's number of points
     * @param numPoints
     */
    public void changeNumPoints(int numPoints) {
        this.numPoints = numPoints;
    }

    /**
     * multiplies the polygon's radius by the scale
     * If radius is set to 0, it is useless.
     * @param scale
     */
    @Override
    public void changeScale(double scale) {
        radius *= scale;
    }

    /**
     * Calculates the area of a regular polygon using the formula:

     * where an is the length of a side and n is the total number of sides.
     * @see <a href="https://www.mathopenref.com/polygonregulararea.html">https://www.mathopenref.com/polygonregulararea.html</a>
     * @return how big the polygon is
     */
    @Override
    public double getArea() {
        //return n × a² × cot(π/n)/ 4
        double sideLength = getSideLength();
        return numPoints * sideLength * sideLength * Math.pow(Math.tan(Math.PI / numPoints), -1) / 4;
    }

    /**
     * uses the following formula to determine the perimeter of a regular polygon:

     * where an is the length of a side and n is the total number of sides.
     */
    @Override
    public double getPerimeterLength() {
        return numPoints * getSideLength();
    }

    /**
     * uses the following formula to determine the perimeter of a regular polygon:

     * where r is the circle's circumference's radius and n is its number of sides.
     * @return the length of a side of the polygon
     */
    public double getSideLength() {
        return 2 * radius * Math.sin(Math.PI / numPoints);
    }

    /**
     * calculates the polygon's vertices
     * While it calculates the vertices, it also includes orientation.
     * @return an array of points that are the vertices of the polygon
     */
    public Point[] getVertices() {
        Point[] vertices = new Point[numPoints];
        Point center = getCenter();
        /*
        for (int i = 0; i < numPoints; i++) {
            vertices[i] = new Point(center.getX() + radius * Math.cos(2 * Math.PI * i / numPoints),
                    center.getY() + radius * Math.sin(2 * Math.PI * i / numPoints));
        }
         */
        for (int i = 0; i < numPoints; i++) {
            vertices[i] = new Point(center.getX() + radius * Math.cos(2 * Math.PI * i / numPoints + orientation),
                    center.getY() + radius * Math.sin(2 * Math.PI * i / numPoints + orientation));
        }
        return vertices;
    }
}
