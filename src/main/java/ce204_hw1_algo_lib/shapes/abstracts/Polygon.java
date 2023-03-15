package ce204_hw1_algo_lib.shapes.abstracts;

import ce204_hw1_algo_lib.Point;

/**
 * Abstract class for Polygon shapes
 * @author Haluk
 */
public abstract class Polygon extends Shape2D {

    /**
     * Constructor
     */
    public Polygon() {
        super();
    }

    /**
     * retrieve the shape's enclosing rectangle
     * @return null bounding rectangle
     */
    public Shape2D getBoundingRect() {
        return null;
    }

    /**
     * retrieve the shape's enclosing rectangle
     * @return null vertices
     */
    public Point[] getVertices() {
        return null;
    }
}
