package Modele;

import java.awt.Color;
import java.awt.Shape;

public class MyShape {
    private Shape shapeBackground;
    private Shape shapeForeground;
    private Color foregroundColor;
    private Color backgroundColor;
    
    public MyShape(Shape shapeForeground, Shape shapeBackground, Color foregroundColor, Color backgroundColor) {
        this.shapeForeground = shapeForeground;
        this.shapeBackground = shapeBackground;
        this.foregroundColor = foregroundColor;
        this.backgroundColor = backgroundColor;
    }

    public Color getForegroundColor() {
        return foregroundColor;
    }
    
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public Shape getShapeBackground() {
        return shapeBackground;
    }

    public Shape getShapeForeground() {
        return shapeForeground;
    } 
}
