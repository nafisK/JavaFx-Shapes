package sample;

import javafx.scene.canvas.GraphicsContext;
import static sample.MyPoint.distance;

public class MyCircle extends MyOval{

    // Instance variables
    // radius of circle
    double r;

    // Constructor
    public MyCircle(MyPoint centerXY, double radius, MyColor color) {
        super(centerXY, radius, radius, color);
        this.r = radius;
    }

    // Getter Methods
    public double getRadius() { return r; }
    public MyPoint getCenter() { return p.getPoint(); };

    // Area and Perimeter
    @Override
    public double getArea() { return Math.PI * Math.pow(r, 2); }
    @Override
    public double getPerimeter() { return 2 * Math.PI * this.r; }

    // Overriding toString method
    @Override
    public String toString() {
        return "MyCircle\n" + "Center: ( "+ p.getX() + ", " + p.getY() + ")\n"+"The radius of the circle is " +
                String.format("% .2f", getRadius()) +
                "\nThe perimeter of the circle is " + String.format("% .2f", getPerimeter()) +
                "\nThe area of the circle is " + String.format("% .2f", getArea()) + "\n";
    }

    // Draws a circle
    @Override
    public void draw (GraphicsContext GC) {
        GC.setFill(color.getColor());
        GC.strokeOval(p.getX(), p.getY(), getRadius(),getRadius());
        GC.fillOval(p.getX(), p.getY(), getRadius(),getRadius());
    }

    // Gets the bounds using a Rectangle format
    @Override
    public MyRectangle getMyBoundingRectangle() {
        double x = p.getX() - r;
        double y = p.getY() - r;
        MyPoint pTLC = new MyPoint(x, y);
        return new MyRectangle(pTLC, 2 * r, 2 * r, null);


    }

    // Finds if a point exists in the circle
    @Override
    public boolean pointInMyShape(MyPoint point) {
        return !(distance(point, this.p) > this.r);
    }



}
