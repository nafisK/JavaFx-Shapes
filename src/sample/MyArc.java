package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import static sample.MyPoint.distance;

public class MyArc extends MyShape{

    // Center of the Arc is in the super class with object "p"

    // Instance variables
    MyPoint startP, endP;   // End points of arc line
    double startAngle;      // Starting angle of the arc drawing
    double realAngle;       // Angle of the respective arc
    double startAngleRad, realAngleRad, endAngleRad; // angles in radians for calculations

    MyOval oval; // oval obj
    int a, b;    // oval half width and height

    MyArc(MyPoint centerPt, int width, int height, double startAngle, double realAngle, MyColor color){
        // center is in super
        super(centerPt, color);
        oval = new MyOval(centerPt, width, height, color);
        this.a = width;
        this.b = height;
        this.startAngle = startAngle;
        this.realAngle = realAngle;
        this.startAngleRad = Math.toRadians(startAngle);
        this.realAngleRad = Math.toRadians(realAngle);
        this.endAngleRad = Math.toRadians(startAngle + realAngle);

        // Calculating the end point coodinates
        int x = (int) p.getX();
        int y = (int) p.getY();
        int x1 = (int) ( x + (double) ( a * b ) / Math.sqrt(Math.pow( b, 2 ) + Math.pow( a * Math.tan(startAngleRad), 2 )));
        int y1 = (int) ( y + (double) ( a * b * Math.tan(startAngleRad)) / Math.sqrt(Math.pow( b, 2 ) + Math.pow(a * Math.tan(startAngleRad), 2)));
        int x2 = (int) ( x + (double) ( a * b ) / Math.sqrt(Math.pow( b, 2 ) + Math.pow( a * Math.tan(endAngleRad), 2 )));
        int y2 = (int) ( y + (double) ( a * b * Math.tan(endAngleRad)) / Math.sqrt(Math.pow( b, 2 ) + Math.pow(a * Math.tan(endAngleRad), 2)));
        this.startP = new MyPoint(x1, y1);
        this.endP = new MyPoint(x2, y2);
        this.oval = new MyOval(p, a, b, color);
    }

    // Get Methods
    public MyPoint getCenter() { return p; }
    public MyPoint getStartPoint() { return startP; }
    public MyPoint getEndPoint() { return endP; }
    public double getStartAngle() { return startAngle; }
    public double getArcAngle() { return realAngle; }
    public MyColor getColor() { return color; }

    // Overidden Methods
    @Override
    public double getArea() {
        double HpW = (double) ( b + a );
        double HmW = (double) ( b - a );
        return (int) ( 0.5 * a * b * (realAngleRad - (
                Math.atan((HmW * Math.sin(2.0 * endAngleRad)) / (HpW + HmW * Math.cos(2.0 * endAngleRad))) -
                Math.atan(HmW * Math.sin(2.0 * startAngleRad)) / (HpW + HmW * Math.cos(2.0 * startAngleRad)))));
    }

    @Override
    public double getPerimeter() {
        return (int) (0.5 * Math.PI / Math.sqrt(2) * distance(startP, endP));
    }

    @Override
    public MyRectangle getMyBoundingRectangle() { return oval.getMyBoundingRectangle(); }

    @Override
    public String toString() {
        return "Arc: \nCenter: " + p + "\nOval Width: " + (2 * a) + ",\nOval Height: " + (2 * b) + ",\n(Start Angle, Arc Angle): ( "
                + startAngle + ", " + realAngle + " ),\nPerimeter: " + this.getPerimeter() + ",\nArea: " + this.getArea();
    }

    @Override
    public void draw(GraphicsContext GC) {
        GC.setFill(color.getColor());
        GC.fillArc(p.getX() - a, p.getY() - b, 2 * a, 2* b, startAngle, realAngle, ArcType.ROUND);
    }
}
