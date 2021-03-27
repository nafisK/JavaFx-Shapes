package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyRectangle extends MyShape{

    // Point: Top Left Corner: p
    double width, height;

    // Contractors
    public MyRectangle(){ super(); this.width = 0; this.height = 0; }
    public MyRectangle(MyPoint TLC, double width, double height, MyColor color) {
        super(TLC, color);
        this.width = width;
        this.height = height;
    }

    // Getter Methods
    public MyPoint getTLC() { return p; };
    public double getWidth() { return width; }
    public double getHeight() { return height; }

    // Gets Area and Perimeter
    @Override
    public double getArea() {
        return width * height;
    }
    @Override
    public double getPerimeter() {
        return 2 * ( width + height);
    }

    // Setter Methods
    public void setWidth(double width) { this.width = width; }
    public void setHeight(double height) { this.height = height; }

    // toString specific to MyRectangle
    @Override
    public String toString(){
        return "Rectangle:\n" + "Coordinate at: ( " + p.getY() + ", " + p.getY() + " )" +
                "\nWidth: " + String.format("% .2f", getWidth()) + ", Height: " + String.format("% .2f", getHeight()) +
                 "\nArea: " + String.format("% .2f",getArea()) + ", Perimeter: " + String.format("% .2f",getPerimeter());
    }

    // Draws a Rectangle
    @Override
    public void draw(GraphicsContext GC) {
        GC.setFill((color.getColor()));
        GC.fillRect(p.getX(), p.getY(), width, height);
    }

    // Checks whether point exists in MyRectangle
    @Override
    public boolean pointInMyShape(MyPoint point) {
        double x = point.getX();
        double y = point.getY();
        return (p.getX() <= x && x <= p.getX() + width) && (p.getY() <= y && y <= p.getY() + height);
    }

    // Gets the bounds of MyRectangle
    @Override
    public MyRectangle getMyBoundingRectangle() {
        return new MyRectangle(p, width, height, null);
    }

}
