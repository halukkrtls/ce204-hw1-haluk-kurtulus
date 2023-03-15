package ce204_hw1_algo_lib.shapes.abstracts;

/**
 * Abstract class for SimplePolygon shapes
 * @author Haluk
 */
public abstract class SimplePolygon extends Polygon {

    /**
     * Orientation of the shape
     */
    protected double orientation;

    /**
     * Constructor
     */
    public SimplePolygon() {
        super();
        orientation = 0;
    }

    /**
     * the shape's axis of rotation
     * @param degree
     * @return
     */
    @Override
    public void rotate(double degree) {
        this.orientation += degree;
    }

    /**
     * find the shape's orientation
     * @return orientation
     */
    public double getOrientation() {
        return orientation;
    }
}
