package Modele;

import java.awt.Color;
import java.awt.Shape;

public abstract class MyShape {
    private Color backgroundColor;
    private Color foregroundColor;
    
    public MyShape(Color backgroundColor, Color foregroundColor) {
        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public Color getForegroundColor() {
        return foregroundColor;
    }
    
    public abstract Shape getShape(); 
}
