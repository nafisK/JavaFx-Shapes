package sample;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main extends Application {

    /*#################### SET FILE LOCATION FIRST ####################*/
    File file = new File("C:/Users/nafis/IdeaProjects/Assignment_1_CSC_21100_R/src/sample/Emma.txt");

    // Global Inputs for testing all classes and methods
    int arcWidth = 200;                                         // Width of the arc
    int arcHeight = 200;                                        // Height of the arc
    MyPoint centerPoint = new MyPoint(500, 350);          // Center Point of the arc/chart
    int startAngle = 0; // Starting angle of the arc/slice      // Starting Angle of the arc/slice
    int realAgnle = 45; // Angle of the respective arc drawn    // Actual Angle of the arc
    char ch = 'X'; double prob = 0.5; int radius = 300;         // values of the arc
    int n;                                                 // Number of slices in the Pie Chart to be displayed
    static Scanner scnr;
    GraphicsContext GC;

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
        GC = canvas.getGraphicsContext2D();

        Scanner scan = new Scanner(System.in);
        System.out.println("Assignment 3");
        System.out.println("My Pie Chart Project");
        System.out.print("Please enter the number alphabets you want to display: ");
        n = scan.nextInt();


        /* Unit Testing MyArc and MySlice */

//        System.out.println("Testing MyArc Class: ");
//        MyArc arcTest = new MyArc(centerPoint, arcWidth, arcHeight, startAngle, realAgnle, MyColor.RED);
//        System.out.println(arcTest.toString());
//        arcTest.draw(GC);
//        drawUnderline();

//        System.out.println("Testing Slice Class: ");
//        Slice sliceTest = new Slice(centerPoint, radius, startAngle, realAgnle, MyColor.BROWN, ch, prob);
//        sliceTest.draw(GC);
//        System.out.println(sliceTest.toString());
//        drawUnderline();

        // FOR MAIN PIE CHART and HISTOGRAM CLASS
        openFile();
        readFile();
        closeFile();


        // Showing drawing in window
        pane.getChildren().add(canvas);
        stage.setTitle("Drawing Shapes");
        stage.setScene(scene);
        stage.show();

    }

    private void openFile() throws IOException {
        scnr = new Scanner(file);

    }
    private void readFile() {
        try {
            String input = "";
            while (scnr.hasNext()){
                input += scnr.nextLine().replaceAll("[^a-zA-Z]", "").toLowerCase();
            }
            HistogramAlphaBet H = new HistogramAlphaBet(input);
            HistogramAlphaBet.MyPieChart pieChart = H.new MyPieChart(n, centerPoint, startAngle, radius);
//            System.out.println(H.toString());
            pieChart.draw(GC);
        }
        catch (NoSuchElementException elementException){
            System.err.println("Invalid Input! Exiting.");
        }
        catch (IllegalStateException stateException) {
            System.out.println("Error Processing File. Exiting.");
        }
    }
    private void closeFile() {
        if (scnr != null) scnr.close();
    }

    void drawUnderline(){
        System.out.println("\n-----------------------------------------------\n");
    }
}
