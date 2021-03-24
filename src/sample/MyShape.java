package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyShape {

    // Instance Variables
    private double x, y;
    MyColor color;

    // Empty Constructor
    MyShape(){
        this.x = 0;
        this.y = 0;
        this.color = MyColor.BLACK;
    }

    // Parameterized Constructor
    MyShape(double x, double y, MyColor color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    // MyShape Getter Methods
    public double getX() { return this.x; }
    public double getY() { return this.y; }
    public MyColor getColor() { return this.color; }

    // Area and Perimeter to be overwritten in sub-class
    public double area() { return 0.0; }
    public double perimeter() { return 0.0; }

    // Returns objects values as String
    @Override
    public String toString() {
        return "\nMyShape:\nThis is a shape object, at (" + x + ", " + y + ") with the color " + color + "\n" ;
    }

    // Draws an empty background
    public void draw(GraphicsContext GC) {
        // Setting the entire canvas to window size
        GC.setFill(color.getColor());
        GC.fillRect(0,0, GC.getCanvas().getWidth(), GC.getCanvas().getHeight());
    }

}
