package ce204_hw1_algo_lib.shapes.abstracts;

/**
 * Abstract class for Elliptical shapes
 * @author Haluk
 */
public abstract class EllipticalShape extends Shape2D {

    /**
     * Shapes' semi-major axes
     */
    protected double semiMajorAxis;


    /**
     * Constructor
     */
    public EllipticalShape() {
        super();
        semiMajorAxis = 1;
    }


}
