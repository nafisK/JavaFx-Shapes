package sample;

import javafx.scene.canvas.GraphicsContext;

public abstract class MyShape implements MyShapeInterface{

    // Instance Variables
//    private double x, y;
    MyPoint p;
    MyColor color;

    // Empty Constructor
    MyShape(){
        // p is already set to 0
        this.color = MyColor.BLACK;
    }

    // Parameterized Constructor
    MyShape(MyPoint p, MyColor color){
        this.p = p;
        this.color = color;
    }

    // MyShape Getter Methods
    public MyPoint getPoint() { return p;}
    public MyColor getColor() { return this.color; }

    // Area and Perimeter to be overwritten in sub-class
    public abstract double getArea();
    public abstract double getPerimeter();

    // Returns objects values as String
    @Override
    public String toString() {
        return "\nMyShape:\nThis is a shape object, at (" + p.getX() + ", " + p.getY() + ") with the color " + color + "\n" ;
    }

    // Draws an empty background
    public abstract void draw(GraphicsContext GC);

    @Override
    public MyRectangle getMyBoundingRectangle() {
        return null;
    }

    @Override
    public boolean pointInMyShape(MyPoint point) {
        return false;
    }
}
