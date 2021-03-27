package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyPolygon extends MyShape {
    // n is the num sides/angles/vertices
    int n;
    double sideLength, minX = 0, xTLC = 0, yTLC = 0, maxX= 0, minY=0, maxY=0;

    // Constructors
    MyPolygon(){
        super();
        this.n = 0;
        this. sideLength = 0;
    }
    MyPolygon (MyPoint centerXY, int nSides, double sideLength, MyColor color ) {
        super(centerXY, color);
        this.n = nSides;
        this.sideLength = sideLength;
    }

    // Getter Methods for MyPolygon
    public MyPoint getCenterXY() { return p.getPoint(); }
    public double getSide() { return sideLength; }
    public double getAngle() { return (double) (180 * ( this.n - 2 )) / this.n; }
    public int getNumSides() { return this.n; }

    // Area and Perimeter
    @Override
    public double getPerimeter(){ return this.n * getSide(); }
    @Override
    public double getArea(){
        double radVal = Math.toRadians( (double) 180/this.n);
        return Math.pow(getSide(),2) * this.n/4 * (Math.tan(radVal));
    }

    // Gets the bounds of MyPolygon
    @Override
    public MyRectangle getMyBoundingRectangle() {

        MyPoint TLC = new MyPoint(xTLC, yTLC);
        double width_height = (getPerimeter() - Math.sqrt(Math.pow(getPerimeter(),2) - (16 * getArea())) / 4);
        return new MyRectangle(TLC, width_height, width_height, null);
    }



    // Overriding toString
    @Override
    public String toString(){
        return "MyPolygon:\nThe Polygon has " + this.n + " number of sides and angles\n" +
                "The side length of each side is " + String.format("%.2f", sideLength) + "\nEach interior angle is " +
                String.format("%.2f", getAngle()) + "\nThe perimeter of the polygon is " + String.format("%.2f", getPerimeter()) +
                "\nThe area of the polygon is " + String.format("% .2f", getArea()) + "\n";
    }

    // Draws a polygon
    public void draw(GraphicsContext GC) {

        // Getting the mas Canvas width for calculating minX and minY
        xTLC = minX = GC.getCanvas().getWidth();
        yTLC = minY = GC.getCanvas().getHeight();
        // MaxX and MaxY is set to 0 for calculating maxX and maxY

        double [] xPolygon = new double[this.n];
        double [] yPolygon = new double[this.n];
        double angle = ((this.n - 1) * getAngle());
        double incrementAngle = ((2 * Math.PI) / this.n);

        for(int i = 0; i < this.n; i++) {

            // Uses loop to find all coordinates
            xPolygon[i] = (int) ( ( getSide() * Math.cos(angle)) + p.getX());
            yPolygon[i] = (int) ( ( getSide() * Math.sin(angle)) + p.getY());

            angle += incrementAngle;

            // Uses loop to find the TLC
            if (xTLC > xPolygon[i]){ xTLC = xPolygon[i]; }
            if (yTLC > yPolygon[i]){ yTLC = yPolygon[i]; }

            // Uses look to find max and min coordinates
            minX(xPolygon[i]); minY(yPolygon[i]);
            maxX(xPolygon[i]); maxY(yPolygon[i]);
        }

        // Fills color and inserts data inside GC
        GC.setFill(color.getColor());
        GC.strokePolygon(xPolygon, yPolygon, this.n);
        GC.fillPolygon(xPolygon, yPolygon, this.n);

    }


    // Finds the min and max coordinates for finding checking if pointsInMyShape exist
    private void minX(double minimum) { if (minimum < minX) { minX = minimum;} }
    private void minY(double minimum) { if (minimum < minY) { minY = minimum;} }
    private void maxX(double maximum) { if (maximum > maxX ) { maxX = maximum;} }
    private void maxY(double maximum) { if (maximum > maxY) { maxY = maximum;} }

    // Checks whether given point is in the MyPolygon exists
    @Override
    public boolean pointInMyShape(MyPoint point) {
        if (point.getX() < this.minX || point.getX() > this.maxX || point.getY() < minY || point.getY() > maxY)
            return false;
        else
            return true;
    }
}
