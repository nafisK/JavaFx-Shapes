package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyLine extends MyShape{

    private double x2, y2;

    public MyLine(double startX, double startY, double endX, double endY, MyColor color) {
        super(startX, startY, color);
        this.x2 = endX;
        this.y2 = endY;
    }

    // Getter Methods - Coordinates & Color
    public double getX1() { return getX(); }
    public double getY1() { return getY(); }
    public double getX2() { return x2; }
    public double getY2() { return y2; }

    // Length and Angle Methods
    public double length(){ return (int) Math.sqrt(Math.pow(x2-getX(),2) + Math.pow(y2-getY(),2)); }
    public double xAngle() {
        return Math.toDegrees(Math.atan( ( y2 - getY() ) / ( x2 - getX() ) ) );
    }

    // Overriding for MyLine objects produced
    @Override
    public String toString () {
        return "MyLine:\nThe Endpoints of the line are: (" + getX() + ", " + getY() + ") & (" + x2 + ", " + y2 +
                ") \nThe length of the line produced is " + String.format("%.2f", length()) +
                "\nThe angle produced with respect to the x-axis is " +
                String.format("%.2f", xAngle()) + " degrees\nThe area is: " + String.format("%.2f", area()) +
                "\nThe Perimeter is: " +
                String.format("%.2f", perimeter()) + "\n";
    }

    // Draws a line
    @Override
    public void draw(GraphicsContext GC) {
        GC.setStroke(color.getColor());
        GC.setLineWidth(8);
        GC.strokeLine(getX(), getY(), this.x2, this.y2);
    }

}
