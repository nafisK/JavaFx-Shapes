package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;

import javax.xml.transform.Source;
import java.sql.SQLOutput;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // CANVAS: variable width and height
        double x = 1000;
        double y = 700;

        // Setting up the window
        StackPane pane = new StackPane();
        Scene scene = new Scene(pane, x,y);
        Canvas canvas = new Canvas(x,y);
        GraphicsContext GC = canvas.getGraphicsContext2D();

        // Drawing Oval
        double ovalMajor = 500, ovalMinor = 300;
        MyOval oval_1 = new MyOval(new MyPoint((0.5 * x), (0.51 * y)), ovalMajor, ovalMinor, MyColor.SILVER);
        oval_1.draw(GC);

        // Drawing Rectangle
        double rectHeight = 675, rectWidth = 500;
        MyRectangle rect_1 = new MyRectangle(new MyPoint((0.25 * x), (0.01 * y)), rectWidth, rectHeight, MyColor.MAROON);
        rect_1.draw(GC);

       // The Circle
        double circleRad_1 = 600, circleRad_2 = 550;
        MyCircle circ_1 = new MyCircle(new MyPoint((0.2 * x),(0.07 * y)), circleRad_1 , MyColor.BLACK);
        circ_1.draw(GC);
        MyCircle circ_2 = new MyCircle(new MyPoint((0.225 * x),(0.107 * y)), circleRad_2, MyColor.TEAL);
        circ_2.draw(GC);

        // Drawing Polygons
        int polyNumSide = 5; double polySideLength = 250;
        MyPolygon poly_1 = new MyPolygon(new MyPoint( (0.5 * x),(0.5 * y)), polyNumSide, polySideLength, MyColor.WHITE);
        poly_1.draw(GC);

        // Drawing the lines shape
        double lineX = 0, lineY = 0;
        MyLine line_1 = new MyLine(new MyPoint(lineX,lineY), new MyPoint(x, y), MyColor.SILVER);
        line_1.draw(GC);
        MyLine line_2 = new MyLine(new MyPoint(x,lineY), new MyPoint(lineX,y), MyColor.SILVER);
        line_2.draw(GC);
        MyLine line_3 = new MyLine(new MyPoint(lineX,lineY), new MyPoint(x,lineY), MyColor.SILVER);
        line_3.draw(GC);
        MyLine line_4 = new MyLine(new MyPoint(lineX,y), new MyPoint(x,y), MyColor.SILVER);
        line_4.draw(GC);
        MyLine line_5 = new MyLine(new MyPoint(lineX,lineY), new MyPoint(lineX,y), MyColor.SILVER);
        line_5.draw(GC);
        MyLine line_6 = new MyLine(new MyPoint(x,lineY), new MyPoint(x,y), MyColor.SILVER);
        line_6.draw(GC);

        // Small circle at center for style
        double circleRad_3 = 50;
        MyCircle circ_3 = new MyCircle(new MyPoint((0.475 * x ),(0.464 * y)), circleRad_3, MyColor.TEAL);
        circ_3.draw(GC);


        // MAIN CONSOLE OUTPUTS ->

        // PRINTING BOUNDS OF SHAPES
        System.out.println("USING getMyBoundingRectangle():");
        drawUnderline();
        System.out.println("Circle Bounds:\n" + circ_3.getMyBoundingRectangle() + "\n");
        System.out.println("Oval Bounds:\n" + oval_1.getMyBoundingRectangle() + "\n");
        System.out.println("Rectangle:\n" + rect_1.getMyBoundingRectangle() + "\n");
        System.out.println("Polygon:\n" + poly_1.getMyBoundingRectangle() + "\n");
        System.out.println("Line:\n" + line_1.getMyBoundingRectangle() + "\n");




        // TESTING POINT COORDINATES
        MyPoint nearLeft = new MyPoint(10, 10);
        MyPoint Center = new MyPoint(500, 350);
        System.out.println("USING pointInMyShape():");
        drawUnderline();

        // Circle
        System.out.println("\nCircle with radius: " + circ_3.getRadius() + " & center " + circ_3.getCenter());
        System.out.println(nearLeft + " " + circ_3.pointInMyShape(nearLeft));
        System.out.println(Center + " " + circ_3.pointInMyShape(Center) + "\n");

        // Oval
        System.out.println("\nOval with Major Axis of: " + oval_1.semiMajor + " & a Minor axis of " + oval_1.semiMinor +
                "\nOval Center"+ oval_1.getCenter());
        System.out.println(nearLeft + " " + oval_1.pointInMyShape(nearLeft));
        System.out.println(Center + " " + oval_1.pointInMyShape(Center) + "\n");

        // Rectangle
        System.out.println("\nRectangle Top Left Corner " + rect_1.getTLC() + "& Height and Width of " +
                rect_1.getHeight() + " " + rect_1.getWidth());
        System.out.println(nearLeft + " " + rect_1.pointInMyShape(nearLeft));
        System.out.println(Center + " " + rect_1.pointInMyShape(Center) + "\n");

        // Line
        System.out.println("\nLine Start  " + line_1.getStartPoint() + ", Line End  " + line_1.getEndPoint());
        System.out.println(nearLeft + " " + line_1.pointInMyShape(nearLeft));
        System.out.println(Center + " " + line_1.pointInMyShape(Center) + "\n");

        // Polygon
        System.out.println("\nPolygon with Center" + poly_1.getCenterXY() + "Number of sides & length of "+
                poly_1.getNumSides() + " & " + poly_1.getSide());
        System.out.println(nearLeft + " " + poly_1.pointInMyShape(nearLeft));
        System.out.println(Center + " " + poly_1.pointInMyShape(Center) + "\n");




        // Printing Intersecting Points
        System.out.println("USING intersectMyShapes():");
        drawUnderline();

        System.out.println("\nIntersecting Oval and Circle:");
        System.out.println(MyShapeInterface.intersectMyShapes(oval_1, circ_1));

        System.out.println("\nIntersecting Rectangle and Horizontal Line:");
        System.out.println(MyShapeInterface.intersectMyShapes(rect_1, line_3) + "\n");

        System.out.println("\nIntersecting Polygon and Circle");
        System.out.println(MyShapeInterface.intersectMyShapes(poly_1, circ_3));




        // Prints string values of the objects used
        System.out.println("\n\nUSING toString():");
        drawUnderline();
        System.out.println(circ_1.toString());
        System.out.println(line_1.toString());
        System.out.println(oval_1.toString());
        System.out.println(rect_1.toString() + "\n");
        System.out.println(Center.toString());
        System.out.println(poly_1.toString());




        // Showing drawing in window
        pane.getChildren().add(canvas);
        stage.setTitle("Drawing Shapes");
        stage.setScene(scene);
        stage.show();

    }

    void drawUnderline(){
        System.out.println("-----------------------------------------------");
    }
}
