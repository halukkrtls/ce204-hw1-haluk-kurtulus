package ce204_hw1_algo_lib.shapes;

import ce204_hw1_algo_lib.Point;
import ce204_hw1_algo_lib.shapes.abstracts.SimplePolygon;

/**
 * Rectangle class
 * @author Haluk
 * @see SimplePolygon
 */
public class Rectangle extends SimplePolygon {

    /**
     * The rectangle's height
     */
    protected double height;

    /**
     * rectangle's width
     */
    protected double width;

    /**
     * Constructor
     * the width and height are set to 0.

     * Sets the orientation to 0
     */
    public Rectangle() {
        super();
        width = 0;
        height = 0;
    }

    /**
     * modify the shape's scale
     * Add the scale to the width and height.
     * @param scale
     */
    @Override
    public void changeScale(double scale) {
        width *= scale;
        height *= scale;
    }

    /**
     * set the rectangle's height
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * set the rectangle's width
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * get the rectangle's height

     * The rectangle's height and breadth are indicated by the letters h and w, respectively.
     * @return height
     */
    @Override
    public double getArea() {
        return width * height;
    }

    /**
     * get the rectangle's perimeter length.
 
     * The rectangle's height and breadth are indicated by the letters h and w, respectively.
     * @return perimeter length
     */
    @Override
    public double getPerimeterLength() {
        return 2 * (width + height);
    }

    /**
     * find the rectangle's vertices
     * @return vertices
     */
    public Point[] getVertices() {
        Point[] vertices = new Point[4];
        Point center = getCenter();
        /*
        vertices[0] = new Point(center.getX() - width / 2, center.getY() - height / 2);
        vertices[1] = new Point(center.getX() + width / 2, center.getY() - height / 2);
        vertices[2] = new Point(center.getX() + width / 2, center.getY() + height / 2);
        vertices[3] = new Point(center.getX() - width / 2, center.getY() + height / 2);
         */

        vertices[0] = new Point(center.getX() - width / 2 * Math.cos(orientation) - height / 2 * Math.sin(orientation),
                center.getY() - width / 2 * Math.sin(orientation) + height / 2 * Math.cos(orientation));
        vertices[1] = new Point(center.getX() + width / 2 * Math.cos(orientation) - height / 2 * Math.sin(orientation),
                center.getY() + width / 2 * Math.sin(orientation) + height / 2 * Math.cos(orientation));
        vertices[2] = new Point(center.getX() + width / 2 * Math.cos(orientation) + height / 2 * Math.sin(orientation),
                center.getY() + width / 2 * Math.sin(orientation) - height / 2 * Math.cos(orientation));
        vertices[3] = new Point(center.getX() - width / 2 * Math.cos(orientation) + height / 2 * Math.sin(orientation),
                center.getY() - width / 2 * Math.sin(orientation) - height / 2 * Math.cos(orientation));
        return vertices;
    }

    
    /**
     * Obtain the rectangle's bounding box.
     * returns the smallest rectangle that the rectangle can fit inside of.
     * The bounding rectangle is the rectangle itself, even when the rectangle is not rotated.
     * The bounding rectangle, when the rectangle is rotated, is the smallest rectangle that encompasses the rectangle.
     * @return bounding rectangle
     */
    public Rectangle getBoundingRect() {
        Point[] vertices = getVertices();
        double minX = vertices[0].getX();
        double maxX = vertices[0].getX();
        double minY = vertices[0].getY();
        double maxY = vertices[0].getY();
        for (int i = 1; i < vertices.length; i++) {
            if (vertices[i].getX() < minX) {
                minX = vertices[i].getX();
            }
            if (vertices[i].getX() > maxX) {
                maxX = vertices[i].getX();
            }
            if (vertices[i].getY() < minY) {
                minY = vertices[i].getY();
            }
            if (vertices[i].getY() > maxY) {
                maxY = vertices[i].getY();
            }
        }
        Rectangle boundingRect = new Rectangle();
        boundingRect.setCenter(center);
        boundingRect.setWidth(maxX - minX);
        boundingRect.setHeight(maxY - minY);
        return boundingRect;
    }
    


    /**
     * get the width of the rectangle
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * get the height of the rectangle
     * @return height
     */
    public double getHeight() {
        return height;
    }
}
