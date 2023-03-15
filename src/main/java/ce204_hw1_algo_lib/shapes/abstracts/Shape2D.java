package ce204_hw1_algo_lib.shapes.abstracts;

import ce204_hw1_algo_lib.Point;

/**
 * Abstract class for 2D shapes
 * @author Haluk
 */
public abstract class Shape2D {

    /**
     * middle of the shape
     */
    protected Point center;

    /**
     * Constructor
     */
    public Shape2D() {
        center = new Point();
    }

    /**
     * the form to the specified position
     * @param dx
     * @param dy
     * @return
     */
    public void translate(double dx, double dy) {
        center.setX(center.getX() + dx);
        center.setY(center.getY() + dy);
    }

    /**
     * find the shape's center
     * @return center
     */
    public Point getCenter() {
        return center;
    }

    /**
     * set the shape's center
     * @param center
     */
    public void setCenter(Point center) {
        this.center = center;
    }

    /**
     * rotate the shape around the center
     * @param degree
     */
    public abstract void rotate(double degree);

    /**
     * scale the form with relation to the middle
     * @param scale
     */
    public abstract void changeScale(double scale);

    /**
     * find the shape's area
     * @return area
     */
    public abstract double getArea();

    /**
     * find the shape's length around the perimeter.
     * @return perimeter length
     */
    public abstract double getPerimeterLength();

    /**
     * retrieve the shape's enclosing rectangle
     * @return bounding rectangle
     */
    public abstract Shape2D getBoundingRect();

}
