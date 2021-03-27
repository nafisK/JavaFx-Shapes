package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyLine extends MyShape{

    // Instance Variables

    // Start pt: p1 (super class)
    // End pt: p2 (instance local)
    MyPoint p2;

    // Constructor
    public MyLine(){
        super();
    }
    public MyLine(MyPoint p1, MyPoint p2, MyColor color) {
        super(p1, color);
        this.p2 = p2;
    }

    // Getter Methods - Coordinates & Color
    public MyPoint getStartPoint() { return p.getPoint(); }
    public MyPoint getEndPoint() { return p2.getPoint(); }

    // Gets area and perimeter
    @Override
    public double getArea() { return 0; }
    @Override
    public double getPerimeter() { return 0; }

    // Gets Length and Angle
    public double length(){ return (int) Math.sqrt(Math.pow(p2.getX()-p.getX(),2) + Math.pow(p2.getY()-p.getY(),2)); }
    public double xAngle() {
        return Math.toDegrees(Math.atan( ( p2.getY() - p.getY() ) / ( p2.getX() - p.getX() ) ) );
    }

    // toString specific to MyLine
    @Override
    public String toString () {
        return "MyLine:\nThe Endpoints of the line are: (" + p.getX() + ", " + p.getY() + ") & (" + p2.getX() +
                ", " + p2.getY() + ") \nThe length of the line produced is " + String.format("%.2f", length()) +
                "\nThe angle produced with respect to the x-axis is " + String.format("%.2f", xAngle()) +
                " degrees\nThe area is: " + String.format("%.2f", getArea()) + "\nThe Perimeter is: " +
                String.format("%.2f", getPerimeter()) + "\n";
    }

    // Draws a line
    @Override
    public void draw(GraphicsContext GC) {
        GC.setStroke(color.getColor());
        GC.setFill(color.getColor());
        GC.setLineWidth(8);
        GC.strokeLine(p.getX(), p.getY(), this.p2.getX(), this.p2.getY());
    }

    // Gets the bounds of the line
    @Override
    public MyRectangle getMyBoundingRectangle() {
        double x_1 = p.getX();
        double y_1 = p.getY();
        double x_2 = p2.getX();
        double y_2 = p2.getY();
        MyPoint TLC = new MyPoint(Math.min(x_1, x_2), Math.min(y_1, y_2));
        return new MyRectangle(TLC, Math.abs(x_1-x_2), Math.abs(y_1 - y_2) , null);
    }

    // Finds if the point exists in the line
    @Override
    public boolean pointInMyShape(MyPoint point) {
        MyRectangle R = this.getMyBoundingRectangle();
        if (R.pointInMyShape(point)){
            double x = point.getX(); double y = point.getY();
            double x_1 = this.p.getX();
            double x_2 = this.p2.getX();
            double y_1 = this.p.getY();
            double y_2 = this.p2.getY();
            double dx = x_1 - x_2; double dy = y_1 - y_2;
            double dd = y_1 * x_2 - x_1 * y_2;
            return dx * y == dy * x + dd;
        }
        else {
            return false;
        }
    }
}
