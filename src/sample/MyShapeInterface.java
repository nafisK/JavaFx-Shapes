package sample;

public interface MyShapeInterface {

    // Interface Methods
    abstract MyRectangle getMyBoundingRectangle();
    abstract boolean pointInMyShape(MyPoint point);


    // Takes in two shapes to find the intersecting point
    public static MyRectangle intersectMyShapes(MyShape A, MyShape B){
        return overlappingRectangles(A.getMyBoundingRectangle(), B.getMyBoundingRectangle());
    }
    // Second Part of intersect MyShapes methods
    public static MyRectangle overlappingRectangles(MyRectangle A, MyRectangle B){

        // Gets coordinates, widths and height
        double x1 = A.getTLC().getX();
        double y1 = A.getTLC().getY();
        double w1 = A.getWidth();
        double h1 = A.getHeight();

        double x2 = B.getTLC().getX();
        double y2 = B.getTLC().getY();
        double w2 = B.getWidth();
        double h2 = B.getHeight();

        // No Intersecting - One rectangle obj is above the other
        if (y1 + h1 < y2 || y1 > y2 + h2) return null;

        // No Intersection - One rectangle obj is next to the other
        if (x1 + w1 < x2 || x1 > x2 + w2 ) return null;

        // Returning not null object
        double xMax = Math.max(x1, x2);
        double yMax = Math.max(y1, y2);
        double xMin = Math.min(x1 + w1, x2 + w2);
        double yMin = Math.min(y1 + h1, y2 + h2);

        MyPoint OverlapPoints = new MyPoint(xMax, yMax);
        return new MyRectangle(OverlapPoints, Math.abs(xMin - xMax), Math.abs(yMin- yMax), null);

    }


}
