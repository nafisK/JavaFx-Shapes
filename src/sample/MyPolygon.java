package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyPolygon extends MyShape {
    // n is the num sides/angles/vertices
    int n;
    double sideLength;

    MyPolygon (double xCent, double yCent, int nSides, double sideLength, MyColor color ) {
        super(xCent,yCent, color);
        this.n = nSides;
        this.sideLength = sideLength;
    }

    // Getter Methods for MyPolygon
    @Override
    public double getX(){ return super.getX(); }
    @Override
    public double getY() { return super.getY(); }
    public double getSide() { return sideLength; }
    public double getAngle() { return (double) (180 * ( this.n - 2 )) / this.n; }

    // Area and Perimeter for toString method
    @Override
    public double perimeter(){ return this.n * getSide(); }
    @Override
    public double area(){
        double radVal = Math.toRadians( (double) 180/this.n);
        return Math.pow(getSide(),2) * this.n/4 * (Math.tan(radVal));
    }

    // Overriding toString
    @Override
    public String toString(){
        return "MyPolygon:\nThe Polygon has " + this.n + " number of sides and angles\n" +
                "The side length of each side is " + String.format("%.2f", sideLength) + "\nEach interior angle is " +
                String.format("%.2f", getAngle()) + "\nThe perimeter of the polygon is " + String.format("%.2f", perimeter()) +
                "\nThe area of the polygon is " + String.format("% .2f", area()) + "\n";
    }

    // Draws a polygon
    public void draw(GraphicsContext GC) {
        double [] xPolygon = new double[this.n];
        double [] yPolygon = new double[this.n];
        double angle = ((this.n - 1) * getAngle());
        double incrementAngle = ((2 * Math.PI) / this.n);

        for(int i = 0; i < this.n; i++) {
            xPolygon[i] = (int) ( ( getSide() * Math.cos(angle)) + getX());
            yPolygon[i] = (int) ( ( getSide() * Math.sin(angle)) + getY());
            angle += incrementAngle;
        }

        // Fills color and inserts data inside GC
        GC.setFill(color.getColor());
        GC.strokePolygon(xPolygon, yPolygon, this.n);
        GC.fillPolygon(xPolygon, yPolygon, this.n);

    }
}
