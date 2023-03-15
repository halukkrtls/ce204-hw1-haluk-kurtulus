package ce204_hw1_algo_lib.shapes;

import java.util.ArrayList;
import java.util.List;

import ce204_hw1_algo_lib.Point;
import ce204_hw1_algo_lib.shapes.abstracts.Polygon;


/**
 * A polygon with arbitrary number of vertices.
 * @author Haluk
 * @see Polygon
 * <p>
 *     A list is used to hold the vertices.
 *     The last vertex and the first vertex are joined.
 * </p>
 */
public class ArbitraryPolygon extends Polygon {

    /**
     * the polygon's points, or vertices.
     * A list is used to hold the vertices. As Point challenges.
     */
    protected List<Point> vertices;

    /**
     * Make a brand-new polygon that has no vertices.
     */
    public ArbitraryPolygon() {
        this.vertices = new ArrayList();
    }

    /**
     * With the provided vertices, make a new polygon.
     * @param vertices The vertices of the polygon.
     */
    public ArbitraryPolygon(List<Point> vertices) {
        this.vertices = vertices;
    }

    /**
     * the polygon with a point.
     * @param point The point to be added.
     */
    public void addPoint(Point point) {
        vertices.add(point);
    }

    /**
     * To the polygon, add a point.
     * @param x The x-coordinate of the point to be added.
     * @param y The y-coordinate of the point to be added.
     */
    public void addPoint(double x, double y) {
        vertices.add(new Point(x, y));
    }

    /**
     * Flip the polygon's center around.
     * @param degree The degree of rotation.
     */
    public void rotate(double degree) {
        for (Point point : vertices) {
            point.rotate(degree, getCenter());
        }
    }

    /**
     * Adjust the polygon's scale in relation to its center.
     * @param scale The scaling factor.
     */
    @Override
    public void changeScale(double scale) {
        Point center = getCenter();
        for (Point point : vertices) {
            point.setX(point.getX() + (point.getX() - center.getX()) * scale);
            point.setY(point.getY() + (point.getY() - center.getY()) * scale);
        }
    }

    /**
     * Compute the polygon's surface area.
     * The following formula is used to determine a polygon's area:  
     * where (xi, yi) is the ith vertex and n is the number of vertices.
     *
     * @return The area of the polygon.
     */
    @Override
    public double getArea() {
        int n = vertices.size();
        double area = 0;
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            Point p1 = vertices.get(i);
            Point p2 = vertices.get(j);
            area += p1.getX() * p2.getY();
            area -= p1.getY() * p2.getX();
        }
        area /= 2;
        return Math.abs(area);
    }

    /**
     * Determine the polygon's perimeter length.
     * The following formula is used to determine a polygon's perimeter length:
 
     * @return The perimeter length of the polygon.
     */
    @Override
    public double getPerimeterLength() {
        int n = vertices.size();
        double perimeter = 0;
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            Point p1 = vertices.get(i);
            Point p2 = vertices.get(j);
            double dx = p2.getX() - p1.getX();
            double dy = p2.getY() - p1.getY();
            perimeter += Math.sqrt(dx * dx + dy * dy);
        }
        return perimeter;
    }
}