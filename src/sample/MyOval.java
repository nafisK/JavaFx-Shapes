package sample;

import javafx.scene.canvas.GraphicsContext;
import static sample.MyPoint.distance;

public class MyOval extends MyShape{

    // Instance Variables
    double semiMajor, semiMinor;

    // Constructors
    public MyOval() {
        this.semiMajor = 0;
        this.semiMinor = 0;
    }
    public MyOval(MyPoint centerXY, double a, double b, MyColor color) {
        super(centerXY, color);
        this.semiMajor = a;
        this.semiMinor = b;
    }

    // Getter Methods
    public MyPoint getCenter() { return p; }
    public double getSemiMajorAxis() { return semiMajor; }
    public double getSemiMinorAxis() { return semiMinor; }

    // Gets Area and Perimeter
    @Override
    public double getArea() { return (int) (Math.PI * semiMinor * semiMinor); }
    @Override
    public double getPerimeter() { return Math.PI * ( 3 * ( semiMajor + semiMinor ) -
            Math.sqrt( ( 3 * semiMajor + semiMinor ) * ( semiMajor + 3 * semiMinor))); }

    // toString specific to MyOval
    @Override
    public String toString(){
        return "MyOval:\nCenter Coordinate: ( " + p.getX() + ", " + p.getY() + " )\nMajor Axis: " + semiMajor +
                ", Minor Axis: " + semiMinor + "\nPerimeter: " + String.format("% .2f",getPerimeter()) + "\nArea: " +
                String.format("% .2f",getArea()) + "\n";
    }

    // Draws an oval
    @Override
    public void draw(GraphicsContext GC) {
        GC.setFill(color.getColor());
        GC.fillOval(p.getX() - semiMajor, p.getY() - semiMinor, 2.0 * semiMajor, 2.0 * semiMinor);
    }

    // Gets the bounds of the Oval
    @Override
    public MyRectangle getMyBoundingRectangle() {
        double x = p.getX() - semiMajor;
        double y = p.getY() - semiMinor;
        MyPoint pTLC = new MyPoint(x, y);
        return new MyRectangle(pTLC, 2 * semiMajor, 2 * semiMinor, null);
    }

    // Finds if a point exists in the Oval
    @Override
    public boolean pointInMyShape(MyPoint point) {
        MyPoint pCenter = this.getCenter();
        double a = this.getSemiMajorAxis();
        double b = this.getSemiMinorAxis();

        if ( a == b) {
            return distance(point, this.p) <= a;
        }
        else {
            double dx = pCenter.getX() - point.getX();
            double dy = pCenter.getY() - point.getY();

            return Math.pow(b * dx, 2) + Math.pow(a * dy, 2) <= Math.pow(a * b, 2);
        }
    }
}
