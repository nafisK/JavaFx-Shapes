package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyCircle extends MyShape{

    // radius of circle
    double r;

    public MyCircle(double CenterX, double CenterY, double radius, MyColor color) {
        super(CenterX, CenterY, color);
        this.r = radius;
    }

    // Getter Methods
    public double getRadius() { return r; }
    @Override
    public double getX(){ return super.getX(); }
    @Override
    public double getY() { return super.getY(); }

    // Area and Perimeter
    @Override
    public double area() { return Math.PI * Math.pow(r, 2); }
    @Override
    public double perimeter() { return 2 * Math.PI * this.r; }

    // Overriding toString method
    @Override
    public String toString() {
        return "MyCircle\n" + "The radius of the circle is " + String.format("% .2f", getRadius()) +
                "\nThe perimeter of the circle is " + String.format("% .2f", perimeter()) +
                "\nThe area of the circle is " + String.format("% .2f", area()) + "\n";
    }

    // Draws a circle
    @Override
    public void draw (GraphicsContext GC) {
        GC.setFill(color.getColor());
        GC.strokeOval(getX(), getY(), getRadius(),getRadius());
        GC.fillOval(getX(), getY(), getRadius(),getRadius());
    }














}
