package ce204_hw1_algo_lib.shapes;

import ce204_hw1_algo_lib.shapes.abstracts.EllipticalShape;

/**
 * Circle class
 * @author Haluk
 * @see EllipticalShape
 */
public class Circle extends EllipticalShape {

    /**
     * Constructor
     * establishes the semi-major axis at 1.
    
     */
    public Circle() {
        super();
    }

    /**
     * the shape's axis of rotation
     * This is a no-op for a circle.
     * @param degree
     * @return
     */
    @Override
    public void rotate(double degree) {}

    /**
     * modify the shape's scale
     * the scale times the semi-major axis
     * If the semi-major axis is zero, it has no effect.
     * @param scale
     */
    @Override
    public void changeScale(double scale) {
        semiMajorAxis *= scale;
    }


    /**
     * find the shape's area
   
     * @return area
     */
    @Override
    public double getArea() {
        return Math.PI * semiMajorAxis * semiMajorAxis;
    }

    /**
     * find the shape's length around the perimeter.
     
     * @return perimeter length
     */
    @Override
    public double getPerimeterLength() {
        return 2 * Math.PI * semiMajorAxis;
    }

    /**
     * retrieve the shape's enclosing rectangle
     * @return bounding rectangle
     */
    @Override
    public Rectangle getBoundingRect() {
        Rectangle boundingRect = new Rectangle();
        boundingRect.setCenter(center);
        boundingRect.setWidth(semiMajorAxis * 2);
        boundingRect.setHeight(semiMajorAxis * 2);
        return boundingRect;
    }
}
