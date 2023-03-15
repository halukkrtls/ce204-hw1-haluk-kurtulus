package ce204_hw1_algo_lib.shapes;

import ce204_hw1_algo_lib.Point;
import ce204_hw1_algo_lib.shapes.abstracts.EllipticalShape;

/**
 * Ellipse class
 * @author Haluk
 * @see EllipticalShape
 */
public class Ellipse extends EllipticalShape {

    /**
     * The ellipse's semi-minor axis
     * The semi-major axis, which is inherited from EllipticalShape, is the opposite axis.
     * @see EllipticalShape
     */
    protected double semiMinorAxis;

    /**
     * The ellipse's orientation
     */
    protected double orientation;

    /**
     * Constructor
     * establishes the semi-major axis at 1.
     * establishes the semi-major axis at 1.
    
     */
    public Ellipse() {
        super();
        semiMinorAxis = 1;
        orientation = 0;
    }


    /**
     * the shape's axis of rotation
     * @param degree
     */
    @Override
    public void rotate(double degree) {
        orientation += degree;
    }

    /**
     * cmodify the shape's scale
     * add the scale to the semi-major and semi-minor axes.
     * If the semi-major axis is zero, it has no effect.
     * @param scale
     */
    @Override
    public void changeScale(double scale) {
        semiMajorAxis *= scale;
        semiMinorAxis *= scale;
    }

    /**
     * find the shape's area
  
     * Semi-major axis (a) and semi-minor axis (b)
     * @return area
     */
    @Override
    public double getArea() {
        return Math.PI * semiMajorAxis * semiMinorAxis;
    }

    /**
     * get the shape's perimeter length

     * Semi-major axis (a) and semi-minor axis (b)
     * @return perimeter length
     */
    @Override
    public double getPerimeterLength() {
        return 2 * Math.PI * Math.sqrt((semiMajorAxis * semiMajorAxis + semiMinorAxis * semiMinorAxis) / 2);
    }

    /**
     * retrieve the shape's enclosing rectangle
     * The bounding rectangle is the rectangle that contains the shape when the orientation is 0.
     * Since the orientation is not 0, a trigonometric calculation must be made to determine what the bounding rectangle is.
     * @return bounding rectangle
     */
    @Override
    public Rectangle getBoundingRect() {
        double topHeight = semiMinorAxis * Math.sqrt(1 - Math.pow(semiMajorAxis / semiMinorAxis, 2) * Math.pow(Math.cos(Math.toRadians(orientation)), 2));
        double bottomHeight = semiMinorAxis * Math.sqrt(1 - Math.pow(semiMajorAxis / semiMinorAxis, 2) * Math.pow(Math.cos(Math.toRadians(orientation + 90)), 2));
        double leftWidth = semiMinorAxis * Math.sqrt(1 - Math.pow(semiMajorAxis / semiMinorAxis, 2) * Math.pow(Math.sin(Math.toRadians(orientation)), 2));
        double rightWidth = semiMinorAxis * Math.sqrt(1 - Math.pow(semiMajorAxis / semiMinorAxis, 2) * Math.pow(Math.sin(Math.toRadians(orientation + 90)), 2));

        double width = leftWidth + rightWidth;
        double height = topHeight + bottomHeight;

        Rectangle boundingRect = new Rectangle();
        boundingRect.setCenter(center);
        boundingRect.setWidth(width);
        boundingRect.setHeight(height);
        return boundingRect;
    }

    /**
     * get the semi-minor axis of the ellipse
     * @return semi-minor axis
     */
    public double getSemiMinorAxis() {
        return semiMinorAxis;
    }


    /**
     * get the semi-major axis of the ellipse
     * @return semi-major axis
     */
    public double getSemiMajorAxis() {
        return semiMajorAxis;
    }


    /**
     * get the first focus of the ellipse
     * see <a href="https://en.wikipedia.org/wiki/Ellipse">https://en.wikipedia.org/wiki/Ellipse</a>
     * @return first focus
     */
    public Point getFocus1() {
        double c = Math.sqrt(semiMajorAxis * semiMajorAxis - semiMinorAxis * semiMinorAxis);
        double x = center.getX() + c * Math.cos(Math.toRadians(orientation));
        double y = center.getY() + c * Math.sin(Math.toRadians(orientation));
        return new Point(x, y);
    }

    /**
     * get the second focus of the ellipse
     * see <a href="https://en.wikipedia.org/wiki/Ellipse">https://en.wikipedia.org/wiki/Ellipse</a>
     * @return second focus
     */
    public Point getFocus2() {
        double c = Math.sqrt(semiMajorAxis * semiMajorAxis - semiMinorAxis * semiMinorAxis);
        double x = center.getX() - c * Math.cos(Math.toRadians(orientation));
        double y = center.getY() - c * Math.sin(Math.toRadians(orientation));
        return new Point(x, y);
    }

    /**
     * set the semi-minor axis of the ellipse
     * @param semiMinorAxis
     */
    public void setSemiMinorAxis(double semiMinorAxis) {
        this.semiMinorAxis = semiMinorAxis;
    }

    /**
     * set the semi-major axis of the ellipse
     * @param semiMajorAxis
     */
    public void setSemiMajorAxis(double semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }

    /**
     * get the orientation of the ellipse
     * @return orientation
     */
    public double getOrientation() {
        return orientation;
    }

    /**
     * set the ellipse's orientation
     * @param orientation orientation
     */
    public void setOrientation(double orientation) {
        this.orientation = orientation;
    }
}
