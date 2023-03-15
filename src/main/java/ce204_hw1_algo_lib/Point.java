package ce204_hw1_algo_lib;


/**
 * Point class
 * @author Haluk
 */
public class Point {

    /**
     * coordinates of the point's x and y
     */
    private double x;
    private double y;

    /**
     * Constructor
     */
    public Point() {
        x = 0;
        y = 0;
    }

    /**
     * Constructor
     * @param x x coordinate
     * @param y y coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * get x coordinate of the point
     * @return x coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * set the point's x coordinate
     * @param x x coordinate
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * find the point's y coordinate
     * @return y coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * set the point's y coordinate
     * @param y y coordinate
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * uses the specified degree and distance from the center to rotate the point around.
     * @param degree degree to rotate
     * @param center center of rotation
     */
    public void rotate(double degree, Point center) {
        double x = this.x - center.x;
        double y = this.y - center.y;

        double rad = Math.toRadians(degree);
        this.x = x * Math.cos(rad) - y * Math.sin(rad) + center.x;
        this.y = x * Math.sin(rad) + y * Math.cos(rad) + center.y;
    }

    /**
     * explain the point
     * @return string representation of the point
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * equals formula
     * @param obj
     * @return true if the points are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Point other = (Point) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
}


