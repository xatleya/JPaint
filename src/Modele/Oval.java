package Modele;

import java.awt.Color;
import java.awt.Shape;

public class Oval extends MyShape{
    private Shape shape;
    
    public Oval(Shape shape, Color backgroundColor, Color foregroundColor) {
        super(backgroundColor, foregroundColor);
        this.shape = shape;
    }

    public Shape getShape() {
        return shape;
    }
}
