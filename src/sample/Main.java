package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // Variable width and height
        double x = 1000;
        double y = 700;

        // Setting up the window
        StackPane pane = new StackPane();
        Scene scene = new Scene(pane, x,y);
        Canvas canvas = new Canvas(x,y);
        GraphicsContext GC = canvas.getGraphicsContext2D();

        // Drawing the shape class with white background into the canvas buffer to be shown
        MyShape shape = new MyShape();
        shape.draw(GC);

        // The Circle
        MyCircle circ1 = new MyCircle( (0.2 * x),(0.07 * y), 600, MyColor.WHITE);
        circ1.draw(GC);
        MyCircle circ2 = new MyCircle((0.225 * x),(0.107 * y), 550, MyColor.TEAL);
        circ2.draw(GC);

        // Drawing Polygons
        MyPolygon poly1 = new MyPolygon( (0.5 * x),(0.5 * y),5, 250, MyColor.WHITE);
        poly1.draw(GC);
        MyPolygon poly2 = new MyPolygon( (0.5 * x),(0.5 * y),6, 200, MyColor.PURPLE);
        poly2.draw(GC);
        MyPolygon poly3 = new MyPolygon( (0.5 * x),(0.5 * y),7, 150, MyColor.RED);
        poly3.draw(GC);
        MyPolygon poly4 = new MyPolygon( (0.5 * x),(0.5 * y),8, 100, MyColor.TEAL);
        poly4.draw(GC);
        MyPolygon poly5 = new MyPolygon( (0.5 * x),(0.5 * y),8, 60, MyColor.NAVY);
        poly5.draw(GC);

        // Drawing the lines shape
        MyLine line_1 = new MyLine(0,0, x, y, MyColor.SILVER);
        line_1.draw(GC);
        MyLine line_2 = new MyLine(x,0, 0,y, MyColor.SILVER);
        line_2.draw(GC);
        MyLine line_3 = new MyLine(0,0, x,0, MyColor.SILVER);
        line_3.draw(GC);
        MyLine line_4 = new MyLine(0,y, x,y, MyColor.SILVER);
        line_4.draw(GC);
        MyLine line_5 = new MyLine(0,0, 0,y, MyColor.SILVER);
        line_5.draw(GC);
        MyLine line_6 = new MyLine(x,0, x, y, MyColor.SILVER);
        line_6.draw(GC);

        // Prints string values of the objects used
        System.out.println(shape.toString());
        System.out.println(line_1.toString());
        System.out.println(poly1.toString());
        System.out.println(circ1.toString());

        // Showing drawing in window
        pane.getChildren().add(canvas);
        stage.setTitle("Drawing Shapes");
        stage.setScene(scene);
        stage.show();

    }
}
