package sample;
import javafx.scene.paint.Color;

public enum MyColor {
    BLACK (0,0,0,255),
    WHITE (255,255,255,255),
    RED (255,0,0,255),
    LIME (0,255,0,255),
    BLUE (0,0,255,255),
    YELLOW (255,255,0,255),
    CYAN (0,255,255,255),
    AQUA (0,255,255,255),
    MAGENTA (255,0,255,255),
    SILVER (192,192,192,255),
    GRAY (128,128,128,255),
    MAROON (128,0,0,255),
    OLIVE (128,128,0,255),
    GREEN (0,128,0,255),
    PURPLE (128,0,128,255),
    TEAL (0,128,128,255),
    NAVY (0,0,128,255);


    // Instance variables
    private final int r, g, b, argb;

    // Empty Constructor default
    MyColor(){
        this.r = 0;
        this.g = 0;
        this.b = 0;
        this.argb = 255;
    }

    // All argument constructor
    MyColor(int r, int g, int b, int argb){
        this.r = r;
        this.g = g;
        this.b = b;
        this.argb = argb;
    }

    // returns values set via constructors
    public Color getColor(){
        return Color.rgb(r, g, b, (double) argb / 255.0 );
    }


}
